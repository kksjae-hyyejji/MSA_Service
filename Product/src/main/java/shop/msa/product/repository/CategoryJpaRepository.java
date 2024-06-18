package shop.msa.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shop.msa.product.domain.Category;

import java.util.List;

public interface CategoryJpaRepository extends JpaRepository<Category,Long> {

    boolean existsByName(String name);

    Category findByName(String name);

    List<Category> findByParentIsNull();
}
