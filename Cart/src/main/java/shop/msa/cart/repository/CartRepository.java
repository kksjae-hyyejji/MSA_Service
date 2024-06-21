package shop.msa.cart.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shop.msa.cart.domain.Cart;
import shop.msa.cart.service.cqrs.CartCommandPort;
import shop.msa.cart.service.cqrs.CartQueryPort;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CartRepository implements CartCommandPort, CartQueryPort {

    private final CartJpaRepository jpa;

    @Override
    public void save(Cart cart) {
        jpa.save(cart);
    }

    @Override
    public Cart findByUserId(String userId) {
        return jpa.findByUserId(userId);
    }
}
