package shop.msa.product.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
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
import shop.msa.product.service.response.ProductInfoResponse;
import shop.msa.product.service.response.ProductResponse;

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

    @Test
    @DisplayName("상품을 7개 생성하고, 페이징의 결과를 확인한다.")
    public void exactlyMatchPagingResult() {

        CategoryServiceCreateRequest c = new CategoryServiceCreateRequest(null, "test");
        categoryService.create(c);

        for (int i = 0; i < 7; i++) {
            ProductCreateRequest request1 = new ProductCreateRequest("등록" + i,"test",3000,30);
            productService.create(request1.toServiceRequest());
        }

        int pageNum = 0;
        Page<ProductResponse> result = productService.getProducts(categoryQueryPort.findByName("test").get().getId(), 0);

        assertThat(result.getTotalElements()).isEqualTo(7);
        assertThat(result.getTotalPages()).isEqualTo(3);
        assertThat(result.getNumber()).isEqualTo(pageNum);
        assertThat(result.getSize()).isEqualTo(3);

    }

    @Test
    @DisplayName("상품 조회에 성공한다.")
    public void getProductInfo() {

        CategoryServiceCreateRequest c = new CategoryServiceCreateRequest(null, "test");
        categoryService.create(c);
        ProductCreateRequest request1 = new ProductCreateRequest("등록","test",3000,30);
        productService.create(request1.toServiceRequest());

        ProductInfoResponse response = productService.getProduct(productQueryPort.findByName("등록").get().getId());

        assertThat(response.getName()).isEqualTo("등록");
        assertThat(response.getPrice()).isEqualTo(3000);
        assertThat(response.getStock()).isEqualTo(30);
    }

    @Test
    @DisplayName("없는 상품 조회에 실패한다.")
    public void failToGetNonExistentProduct() {

        assertThrows(CustomException.class, () -> productService.getProduct(1L));
    }
}