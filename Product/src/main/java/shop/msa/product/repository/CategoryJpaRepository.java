package shop.msa.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.msa.product.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryJpaRepository extends JpaRepository<Category,Long> {

    boolean existsByName(String name);

    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.childs WHERE c.name = :name")
    Optional<Category> findByName(String name);

    List<Category> findByParentIsNull();
}
