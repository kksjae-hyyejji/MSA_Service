package shop.msa.cart.service.cqrs;

import shop.msa.cart.domain.Cart;

public interface CartQueryPort {

    Cart findByUserId(String userId);
}
