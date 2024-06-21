package shop.msa.cart.controller.request;

import lombok.Getter;
import shop.msa.cart.service.request.CartServiceAddRequest;

@Getter
public class CartAddRequest {

    private Long id;
    private String name;
    private int price;

    public CartAddRequest(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public CartServiceAddRequest toServiceRequest() {

        return new CartServiceAddRequest(id, name, price);
    }
}
