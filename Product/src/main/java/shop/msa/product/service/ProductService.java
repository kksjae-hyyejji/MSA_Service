package shop.msa.product.service;

import shop.msa.product.service.request.ProductServiceCreateRequest;

public interface ProductService {

    void create(ProductServiceCreateRequest request);
}
