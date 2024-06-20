package shop.msa.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import shop.msa.product.domain.Category;
import shop.msa.product.domain.Product;
import shop.msa.product.domain.ProductCategory;
import shop.msa.product.exception.CustomException;
import shop.msa.product.exception.ErrorCode;
import shop.msa.product.service.CategoryService;
import shop.msa.product.service.ProductService;
import shop.msa.product.service.cqrs.CategoryQueryPort;
import shop.msa.product.service.cqrs.ProductCommandPort;
import shop.msa.product.service.cqrs.ProductQueryPort;
import shop.msa.product.service.request.ProductServiceCreateRequest;
import shop.msa.product.service.response.ProductResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductCommandPort productCommandPort;
    private final ProductQueryPort productQueryPort;
    private final CategoryQueryPort categoryQueryPort;
    private final CategoryService categoryService;

    @Override
    public void create(ProductServiceCreateRequest request) {

        Category category = categoryQueryPort.findByName(request.getCategory())
                .orElseThrow(() -> new CustomException(ErrorCode.NON_EXISTENT_CATEGORY));
        if (!category.getChilds().isEmpty()) throw new CustomException(ErrorCode.NOT_LOWEST_CATEGORY);
        if (productQueryPort.existsByName(request.getName())) throw new CustomException(ErrorCode.DUPLICATE_PRODUCT);

        Product product = Product.create(request.getName(), request.getPrice(),
                request.getStockQuantity());
        ProductCategory productCategory = ProductCategory.create(product, category);
        product.addCategory(productCategory);

        productCommandPort.save(product);
    }

    @Override
    public Page<ProductResponse> getProducts(Long categoryId, int pageNum) {

        List<Long> ids = categoryService.findLowestCategoryIds(categoryId);
        Page<Product> products = productQueryPort.findDistinctByCategories_Category_IdIn(ids, PageRequest.of(pageNum, 3));

        return products.map(p -> new ProductResponse(p.getId(), p.getName(), p.getPrice()));
    }
}
