package shop.msa.product.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import shop.msa.product.domain.Product;
import shop.msa.product.service.cqrs.ProductCommandPort;
import shop.msa.product.service.cqrs.ProductQueryPort;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Product> findByName(String name) {
        return productJpaRepository.findByName(name);
    }

    @Override
    public Page<Product> findDistinctByCategories_Category_IdIn(List<Long> categoryIds, Pageable pageable) {
        return productJpaRepository.findDistinctByCategories_Category_IdIn(categoryIds, pageable);
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return productJpaRepository.findById(productId);
    }

}
