package shop.msa.cart.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import shop.msa.cart.domain.CartProduct;
import shop.msa.cart.service.cqrs.CartProductQueryPort;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CartProductRepository implements CartProductQueryPort {

    private final CartProductJpaRepository jpa;

    @Override
    public List<CartProduct> findAllByCartId(Long id) {
        return jpa.findByCartId(id);
    }
}
