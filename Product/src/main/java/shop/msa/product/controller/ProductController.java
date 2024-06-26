package shop.msa.product.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.netflix.eureka.http.WebClientEurekaHttpClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import shop.msa.product.controller.request.OrderProductRequest;
import shop.msa.product.controller.request.ProductCreateRequest;
import shop.msa.product.response.CommonResponse;
import shop.msa.product.service.ProductService;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/{categoryId}")
    public ResponseEntity<CommonResponse> getProducts(@PathVariable Long categoryId, int pageNum) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder().
                        message("상품 리스트")
                        .data(Map.of("productList",productService.getProducts(categoryId, pageNum)))
                        .build());
    }

    @GetMapping("{productId}")
    public ResponseEntity<CommonResponse> getProduct(@PathVariable Long productId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .message("상품 상세 정보")
                        .data(Map.of("product", productService.getProduct(productId)))
                        .build());
    }

    @PostMapping("/{productId}")
    public ResponseEntity<CommonResponse> addToCart(@RequestHeader String username, @PathVariable Long productId) {

        productService.addToCart(username, productId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .message("장바구니에 추가되었습니다.")
                        .build());
    }

    @PostMapping("/order")
    public ResponseEntity<CommonResponse> order(@RequestHeader String username, @RequestBody List<OrderProductRequest> orders) {

        productService.order(username, orders);

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .message("주문이 접수되었습니다.")
                        .build());
    }
}
