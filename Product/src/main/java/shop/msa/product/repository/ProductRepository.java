package shop.msa.product.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shop.msa.product.domain.Product;
import shop.msa.product.service.cqrs.ProductCommandPort;
import shop.msa.product.service.cqrs.ProductQueryPort;

@Component
@RequiredArgsConstructor
public class ProductRepository implements ProductCommandPort, ProductQueryPort {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public void save(Product product) {
        productJpaRepository.save(product);
    }

    @Override
    public boolean existsByName(String name) {
        return productJpaRepository.existsByName(name);
    }
}
