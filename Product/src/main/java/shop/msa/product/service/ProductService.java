package shop.msa.product.service;

import org.springframework.data.domain.Page;
import shop.msa.product.service.request.ProductServiceCreateRequest;
import shop.msa.product.service.response.ProductInfoResponse;
import shop.msa.product.service.response.ProductResponse;


public interface ProductService {

    void create(ProductServiceCreateRequest request);

    Page<ProductResponse> getProducts(Long categoryId, int pageNum);

    ProductInfoResponse getProduct(Long productId);

    void addToCart(String name, Long productId);
}
