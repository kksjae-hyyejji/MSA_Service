package shop.msa.product.service.cqrs;

import shop.msa.product.domain.Category;

public interface CategoryCommandPort {
    void save(Category category);
}
