package shop.msa.product.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.msa.product.domain.Category;
import shop.msa.product.exception.CustomException;
import shop.msa.product.exception.ErrorCode;
import shop.msa.product.service.CategoryService;
import shop.msa.product.service.cqrs.CategoryCommandPort;
import shop.msa.product.service.cqrs.CategoryQueryPort;
import shop.msa.product.service.request.CategoryServiceCreateRequest;
import shop.msa.product.service.response.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryCommandPort categoryCommandPort;
    private final CategoryQueryPort categoryQueryPort;

    private List<CategoryResponse> categoryCache = new ArrayList<>();

    @PostConstruct
    public void init() {
        refreshCategoryCache();
    }

    @Override
    @Transactional
    public void create(CategoryServiceCreateRequest request) {

        if(categoryQueryPort.existsByName(request.getName())) {
            throw new CustomException(ErrorCode.DUPLICATE_CATEGORY);
        }

        Category parent = existOrNull(request.getParentId());
        Category category = Category.createCategory(request.getName(), parent);
        categoryCommandPort.save(category);
        refreshCategoryCache();
    }

    @Override
    public List<Long> findLowestCategoryIds(Long categoryId) {

        CategoryResponse category = findCategoryById(categoryCache, categoryId);
        if (category == null) {
            throw new CustomException(ErrorCode.NON_EXISTENT_PARENT);
        }

        return category.extractLowestCategoryIds();
    }

    private CategoryResponse findCategoryById(List<CategoryResponse> categories, Long categoryId) {
        for (CategoryResponse category : categories) {
            if (category.getId().equals(categoryId)) {
                return category;
            } else {
                CategoryResponse found = findCategoryById(category.getChild(), categoryId);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryCache;
    }

    private Category existOrNull(Long parentId) {
        return parentId == null ? null : categoryQueryPort.findById(parentId)
                .orElseThrow(() -> new CustomException(ErrorCode.NON_EXISTENT_PARENT));
    }

    private void refreshCategoryCache() {
        List<Category> roots = categoryQueryPort.findByParentIsNull();

        categoryCache = roots.stream()
                .map(CategoryResponse::of)
                .collect(toList());
    }
}
