package shop.msa.cart.service.request;

import lombok.Getter;

@Getter
public class CartServiceAddRequest {

    private Long id;
    private String name;
    private int price;

    public CartServiceAddRequest(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
