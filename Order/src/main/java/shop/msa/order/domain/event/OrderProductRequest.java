package shop.msa.order.domain.event;

import lombok.Getter;

@Getter
public class OrderProductRequest {

    private Long productId;

    private String productName;

    private int quantity;
}
