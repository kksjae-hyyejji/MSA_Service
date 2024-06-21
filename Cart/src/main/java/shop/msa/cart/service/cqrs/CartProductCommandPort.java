package shop.msa.cart.service.cqrs;

import shop.msa.cart.domain.CartProduct;

public interface CartProductCommandPort {

    void save(CartProduct cartProduct);
}
