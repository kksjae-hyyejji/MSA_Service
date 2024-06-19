package shop.msa.product.service.cqrs;

import shop.msa.product.domain.Product;

import java.util.Optional;

public interface ProductQueryPort {

    boolean existsByName(String name);

    Optional<Product> findByName(String name);
}
