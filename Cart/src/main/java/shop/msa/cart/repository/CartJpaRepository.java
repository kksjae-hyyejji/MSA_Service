package shop.msa.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.msa.cart.domain.Cart;

public interface CartJpaRepository extends JpaRepository<Cart, Long> {

    Cart findByUserId(String userId);
}
