package shop.msa.product.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.msa.product.controller.request.OrderProductRequest;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderCreateEvent {

    private String username;

    private List<OrderProductRequest> orderProducts;
}
