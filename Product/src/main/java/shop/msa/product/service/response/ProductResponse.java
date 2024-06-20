package shop.msa.product.service.response;

import lombok.Getter;

@Getter
public class ProductResponse {

    private Long id;
    private String name;
    private int price;

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public ProductResponse(Long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
