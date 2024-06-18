package shop.msa.product.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.msa.product.domain.enumtype.SellingStatus;

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

}
