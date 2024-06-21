package shop.msa.cart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.msa.cart.response.CommonResponse;
import shop.msa.cart.service.CartService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {


    private final CartService cartService;

    @GetMapping("/myCart")
    public ResponseEntity<CommonResponse> getCartProducts(@RequestHeader String userId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .message("카트 상품 조회")
                        .data(Map.of("CartProducts", cartService.getCartProducts(userId)))
                        .build());
    }
}
