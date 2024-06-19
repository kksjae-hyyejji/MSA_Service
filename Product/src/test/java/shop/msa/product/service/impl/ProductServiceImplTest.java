package shop.msa.product.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import shop.msa.product.controller.request.ProductCreateRequest;
import shop.msa.product.domain.Product;
import shop.msa.product.exception.CustomException;
import shop.msa.product.service.CategoryService;
import shop.msa.product.service.ProductService;
import shop.msa.product.service.cqrs.CategoryQueryPort;
import shop.msa.product.service.cqrs.ProductQueryPort;
import shop.msa.product.service.request.CategoryServiceCreateRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class ProductServiceImplTest {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductQueryPort productQueryPort;
    @Autowired
    CategoryQueryPort categoryQueryPort;

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

    @Test
    @DisplayName("최하위 카테고리가 아닌 상품 등록 실패")
    public void createProductNotLowestCategory() {
        //given
        CategoryServiceCreateRequest request1 = new CategoryServiceCreateRequest(null, "cloth");
        categoryService.create(request1);
        CategoryServiceCreateRequest request2 = new CategoryServiceCreateRequest(categoryQueryPort.findByName("cloth").get().getId(), "bottom");
        CategoryServiceCreateRequest request3 = new CategoryServiceCreateRequest(categoryQueryPort.findByName("cloth").get().getId(), "top");
        categoryService.create(request2);
        categoryService.create(request3);

        ProductCreateRequest request = new ProductCreateRequest("등록","cloth",3000,30);

        //when & then
        assertThrows(CustomException.class, () -> productService.create(request.toServiceRequest()));
    }

    @Test
    @DisplayName("동일한 상품 이름 등록 실패")
    public void createDuplicateProduct() {
        //given
        CategoryServiceCreateRequest c = new CategoryServiceCreateRequest(null, "cloth");
        categoryService.create(c);
        ProductCreateRequest request1 = new ProductCreateRequest("등록","cloth",3000,30);
        //when & then
        productService.create(request1.toServiceRequest());
        assertThrows(CustomException.class, () -> productService.create(request1.toServiceRequest()));
    }
}