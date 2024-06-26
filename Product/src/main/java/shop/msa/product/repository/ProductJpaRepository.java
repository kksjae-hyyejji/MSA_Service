package shop.msa.product.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.msa.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);

    Optional<Product> findByName(String name);

    @Query(countQuery = "SELECT count(distinct(pc.id)) FROM ProductCategory pc WHERE pc.id IN :ids")
    Page<Product> findDistinctByCategories_Category_IdIn(List<Long> ids, Pageable pageable);

    List<Product> findByIdIn(List<Long> productIds);
}
