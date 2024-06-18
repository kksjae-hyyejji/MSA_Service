package shop.msa.product.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.msa.product.controller.request.CategoryCreateRequest;
import shop.msa.product.response.CommonResponse;
import shop.msa.product.service.CategoryService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse> create(@RequestBody @Valid CategoryCreateRequest categoryCreateRequest) {

        categoryService.create(categoryCreateRequest.toServiceRequest());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.builder().
                        message("카테고리 생성 완료").
                        build());
    }

    @GetMapping("/all")
    public ResponseEntity<CommonResponse> all() {

        return ResponseEntity.status(HttpStatus.OK).
                body(CommonResponse.builder().
                        message("모든 카테고리 조회").
                        data(Map.of("AllCategories", categoryService.getAllCategories())).
                        build());

    }
}
