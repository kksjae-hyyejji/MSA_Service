package shop.msa.product.service.cqrs;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import shop.msa.product.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductQueryPort {

    boolean existsByName(String name);

    Optional<Product> findByName(String name);

    Page<Product> findDistinctByCategories_Category_IdIn(List<Long> categoryIds, Pageable pageable);

    Optional<Product> findById(Long productId);

    List<Product> findByIdIn(List<Long> productIds);
}
