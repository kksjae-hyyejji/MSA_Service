package shop.msa.product.service.cqrs;


import shop.msa.product.domain.Product;

public interface ProductCommandPort {
    void save(Product product);
}
