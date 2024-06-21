package shop.msa.cart.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyCartProductResponse {

    private Long productId;

    private String productName;

    private int price;
}
