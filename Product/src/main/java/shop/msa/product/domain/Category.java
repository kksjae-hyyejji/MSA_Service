package shop.msa.product.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "shop_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private int depth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL)
    private List<Category> childs = new ArrayList<>();

    private Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
        this.depth = parent == null ? 1 : parent.getDepth() + 1;
    }

    public void addChild(Category category) {
        this.childs.add(category);
        category.parent = this;
    }

    public static Category createCategory(String name, Category parent) {

        Category category = new Category(name, parent);
        if (parent != null) {
            parent.addChild(category);
        }
        return category;
    }
}
