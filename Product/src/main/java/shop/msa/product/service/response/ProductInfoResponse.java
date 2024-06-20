package shop.msa.product.service.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductInfoResponse {

    private Long id;
    private String name;
    private int price;
    private int stock;


}
