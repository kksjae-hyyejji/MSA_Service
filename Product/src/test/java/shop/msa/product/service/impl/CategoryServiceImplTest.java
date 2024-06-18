package shop.msa.product.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.msa.product.domain.Category;
import shop.msa.product.exception.CustomException;
import shop.msa.product.service.CategoryService;
import shop.msa.product.service.cqrs.CategoryCommandPort;
import shop.msa.product.service.cqrs.CategoryQueryPort;
import shop.msa.product.service.request.CategoryServiceCreateRequest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryCommandPort categoryCommandPort;

    @Autowired
    CategoryQueryPort categoryQueryPort;

    @Test
    @DisplayName("카테고리 생성 성공")
    public void createCategory() {

        CategoryServiceCreateRequest request = new CategoryServiceCreateRequest(null, "one");
        //when
        categoryService.create(request);

        //then
        Category category = categoryQueryPort.findByName("one");
        log.info("name = {}, parent = {} ",category.getName(), category.getParent());
    }

    @Test
    @DisplayName("중복된 카테고리 이름 생성 실패")
    public void createDuplicateNameCategory() {
        //given
        CategoryServiceCreateRequest request1 = new CategoryServiceCreateRequest(null, "duplicate");
        CategoryServiceCreateRequest request2 = new CategoryServiceCreateRequest(null, "duplicate");
        //when
        categoryService.create(request1);

        //then
        assertThrows(CustomException.class, () -> categoryService.create(request2));
    }
}