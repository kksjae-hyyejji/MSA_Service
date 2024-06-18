package shop.msa.product.service.cqrs;

import shop.msa.product.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryQueryPort {
    Optional<Category> findById(Long parentId);

    boolean existsByName(String name);

    Category findByName(String cloth);

    List<Category> findByParentIsNull();
}
