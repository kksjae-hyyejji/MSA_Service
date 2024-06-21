package shop.msa.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
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
import shop.msa.product.service.response.ProductInfoResponse;
import shop.msa.product.service.response.ProductResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductCommandPort productCommandPort;
    private final ProductQueryPort productQueryPort;
    private final CategoryQueryPort categoryQueryPort;
    private final CategoryService categoryService;
    private final WebClient cartWebClient;

    @Override
    @Transactional
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

    @Override
    public ProductInfoResponse getProduct(Long productId) {

        Product product = productQueryPort.findById(productId).orElseThrow(() -> new CustomException(ErrorCode.NON_EXISTENT_PRODUCT));
        return new ProductInfoResponse(product.getId(),product.getName(), product.getPrice(), product.getStock());
    }

    @Override
    public void addToCart(String userId, Long productId) {

        cartWebClient.post()
                .body(BodyInserters.empty())
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
    }
}
