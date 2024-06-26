package shop.msa.order.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderCreateEvent {

    private String username;

    private List<OrderProductRequest> orderProducts;
}
