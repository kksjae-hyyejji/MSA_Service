package shop.msa.product.service;

import shop.msa.product.service.request.CategoryServiceCreateRequest;
import shop.msa.product.service.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    void create(CategoryServiceCreateRequest request);

    List<CategoryResponse> getAllCategories();

    List<Long> findLowestCategoryIds(Long categoryId);
}
