package shop.msa.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.msa.cart.domain.CartProduct;

import java.util.List;

public interface CartProductJpaRepository extends JpaRepository<CartProduct, Long> {

    List<CartProduct> findByCartId(Long cartId);
}
