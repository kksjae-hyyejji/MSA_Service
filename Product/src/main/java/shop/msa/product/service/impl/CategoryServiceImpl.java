package shop.msa.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.msa.product.domain.Category;
import shop.msa.product.exception.CustomException;
import shop.msa.product.exception.ErrorCode;
import shop.msa.product.service.CategoryService;
import shop.msa.product.service.cqrs.CategoryCommandPort;
import shop.msa.product.service.cqrs.CategoryQueryPort;
import shop.msa.product.service.request.CategoryServiceCreateRequest;
import shop.msa.product.service.response.CategoryResponse;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryCommandPort categoryCommandPort;
    private final CategoryQueryPort categoryQueryPort;

    @Override
    public void create(CategoryServiceCreateRequest request) {

        if(categoryQueryPort.existsByName(request.getName())) {
            throw new CustomException(ErrorCode.DUPLICATE_CATEGORY);
        }

        Category parent = existOrNull(request.getParentId());
        Category category = Category.createCategory(request.getName(), parent);
        categoryCommandPort.save(category);

    }

    @Override
    public List<CategoryResponse> getAllCategories() {

        List<Category> roots = categoryQueryPort.findByParentIsNull();

        return roots.stream()
                .map(CategoryResponse::of)
                .collect(toList());
    }

    private Category existOrNull(Long parentId) {
        return parentId == null ? null : categoryQueryPort.findById(parentId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 부모 카테고리 값 입력"));

    }
}
