package shop.msa.product.service.request;

import lombok.Getter;

@Getter
public class ProductServiceCreateRequest {

    private String name;
    private String category;
    private int price;
    private int stockQuantity;

    public ProductServiceCreateRequest(String name, String category, int price, int stockQuantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

}
