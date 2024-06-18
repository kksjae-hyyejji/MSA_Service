package shop.msa.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shop.msa.product.domain.Product;

import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);

    Optional<Product> findByName(String name);

}
