package shop.msa.cart.service.cqrs;

import shop.msa.cart.domain.CartProduct;

import java.util.List;

public interface CartProductQueryPort {

    List<CartProduct> findAllByCartId(Long id);
}

