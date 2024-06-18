package shop.msa.product.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import shop.msa.product.service.request.ProductServiceCreateRequest;

@Getter
public class ProductCreateRequest {

    @NotBlank(message = "상품 이름은 필수입니다.")
    private String name;

    @NotBlank(message = "카테고리 설정은 필수입니다.")
    private String category;

    private int price;

    private int stockQuantity;

    public ProductCreateRequest(String name, String category, int price, int stockQuantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public ProductServiceCreateRequest toServiceRequest() {

        return new ProductServiceCreateRequest(name, category, price, stockQuantity);
    }
}
