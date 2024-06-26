package shop.msa.product.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class OrderProductRequest {

    @NotBlank(message = "productId가 존재하지 않습니다.")
    private Long productId;

    @NotBlank(message = "productName이 존재하지 않습니다.")
    private String productName;

    @Positive(message = "1개 이상 선택하지 않은 상품이 존재합니다.")
    private int quantity;
}
