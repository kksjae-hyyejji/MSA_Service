package shop.msa.product.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.msa.product.controller.request.ProductCreateRequest;
import shop.msa.product.response.CommonResponse;
import shop.msa.product.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<CommonResponse> create(@RequestBody @Valid ProductCreateRequest productCreateRequest) {

        productService.create(productCreateRequest.toServiceRequest());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.builder().
                        message("상품 생성 완료")
                        .build());
    }
}
