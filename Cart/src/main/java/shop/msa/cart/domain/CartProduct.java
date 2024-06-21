package shop.msa.cart.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Table(name = "shop_cart_product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_product_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(unique = true)
    private Long productId;

    private String productName;

    private int price;

    private CartProduct(Cart cart, Long productId, String productName, int price) {
        this.cart = cart;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public static CartProduct create(Cart cart, Long productId, String name, int price) {

        return new CartProduct(cart, productId, name, price);
    }
}
