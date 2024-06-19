package shop.msa.product.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shop.msa.product.domain.Category;
import shop.msa.product.service.cqrs.CategoryCommandPort;
import shop.msa.product.service.cqrs.CategoryQueryPort;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryRepository implements CategoryCommandPort, CategoryQueryPort {

    private final CategoryJpaRepository categoryJpaRepository;

    @Override
    public Optional<Category> findById(Long parentId) {
        return categoryJpaRepository.findById(parentId);
    }

    @Override
    public boolean existsByName(String name) {
        return categoryJpaRepository.existsByName(name);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryJpaRepository.findByName(name);
    }

    @Override
    public List<Category> findByParentIsNull() {
        return categoryJpaRepository.findByParentIsNull();
    }

    @Override
    public void save(Category category) {
        categoryJpaRepository.save(category);
    }
}
