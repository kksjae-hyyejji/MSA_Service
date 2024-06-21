package shop.msa.cart.service.cqrs;

import shop.msa.cart.domain.Cart;

public interface CartCommandPort {

    void save(Cart cart);

}
