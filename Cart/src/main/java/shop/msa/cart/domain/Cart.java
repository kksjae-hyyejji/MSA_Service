package shop.msa.cart.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "shop_cart", indexes = @Index(columnList = "user_id", unique = true))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    private Cart(String userId) {
        this.userId = userId;
    }

    public static Cart create(String userId) {
        return new Cart(userId);
    }
}

