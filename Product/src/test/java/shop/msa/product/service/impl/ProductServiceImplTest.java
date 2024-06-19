package shop.msa.product.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import shop.msa.product.controller.request.ProductCreateRequest;
import shop.msa.product.domain.Product;
import shop.msa.product.service.CategoryService;
import shop.msa.product.service.ProductService;
import shop.msa.product.service.cqrs.ProductQueryPort;
import shop.msa.product.service.request.CategoryServiceCreateRequest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ProductServiceImplTest {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductQueryPort productQueryPort;

    @Test
    @DisplayName("상품 등록 성공")
    public void createProduct() {
        CategoryServiceCreateRequest c = new CategoryServiceCreateRequest(null, "knit");
        categoryService.create(c);
        ProductCreateRequest request = new ProductCreateRequest("등록","knit",3000,30);
        productService.create(request.toServiceRequest());

        //when
        Product product = productQueryPort.findByName("등록").orElseThrow(() ->
                new IllegalStateException("해당 상품을 찾을 수 없음"));

        //then
        assertThat(product.getName()).isEqualTo("등록");
    }
}