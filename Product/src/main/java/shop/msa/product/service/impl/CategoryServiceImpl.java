package shop.msa.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.msa.product.service.CategoryService;
import shop.msa.product.service.cqrs.CategoryCommandPort;
import shop.msa.product.service.cqrs.CategoryQueryPort;
import shop.msa.product.service.request.CategoryServiceCreateRequest;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryCommandPort categoryCommandPort;
    private final CategoryQueryPort categoryQueryPort;

    @Override
    public void create(CategoryServiceCreateRequest request) {

    }
}
