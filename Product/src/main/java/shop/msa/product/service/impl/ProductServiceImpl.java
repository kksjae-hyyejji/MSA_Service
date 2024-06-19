package shop.msa.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.msa.product.service.ProductService;
import shop.msa.product.service.cqrs.ProductCommandPort;
import shop.msa.product.service.cqrs.ProductQueryPort;
import shop.msa.product.service.request.ProductServiceCreateRequest;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductCommandPort productCommandPort;
    private final ProductQueryPort productQueryPort;

    @Override
    public void create(ProductServiceCreateRequest request) {


    }
}
