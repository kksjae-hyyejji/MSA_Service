package shop.msa.product.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.msa.product.domain.enumtype.SellingStatus;
import shop.msa.product.exception.CustomException;
import shop.msa.product.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "shop_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private int price;
    private int stock;

    @Enumerated(EnumType.STRING)
    private SellingStatus status;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductCategory> categories = new ArrayList<>();

    private Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.categories = new ArrayList<>();
        this.status = SellingStatus.SELLING;
    }

    public static Product create(String name, int price, int stockQuantity) {

        return new Product(name, price, stockQuantity);
    }

    public void addCategory(ProductCategory productCategory) {
        this.categories.add(productCategory);
    }

    public void canAddToCart() {
        if (this.stock <= 0) throw new CustomException(ErrorCode.OUT_OF_STOCK);
    }

    public void canBuy(int quantity) {

        canAddToCart();
        if (this.stock < quantity) throw new CustomException(ErrorCode.INSUFFICIENT_STOCK);
    }
}
