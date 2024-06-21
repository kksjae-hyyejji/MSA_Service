package shop.msa.cart.service.impl;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.msa.cart.domain.Cart;
import shop.msa.cart.domain.CartProduct;
import shop.msa.cart.service.CartService;
import shop.msa.cart.service.cqrs.CartCommandPort;
import shop.msa.cart.service.cqrs.CartProductCommandPort;
import shop.msa.cart.service.cqrs.CartProductQueryPort;
import shop.msa.cart.service.cqrs.CartQueryPort;
import shop.msa.cart.service.request.CartServiceAddRequest;
import shop.msa.cart.service.response.MyCartProductResponse;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {

    private final CartProductQueryPort cartProductQueryPort;
    private final CartProductCommandPort cartProductCommandPort;
    private final CartCommandPort cartCommandPort;
    private final CartQueryPort cartQueryPort;
    private final EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<MyCartProductResponse> getCartProducts(String userId) {

        Cart cart = cartQueryPort.findByUserId(userId);

        // 최초 카트가 없는 경우에는 상품이 하나도 없다. 따라서 flush로 db에 반영 (GenerationType.IDENTITY타입이므로 db에 반영이 필수)
        if (cart == null) {
            cart = createCart(userId);
        }
        List<CartProduct> cartProducts = cartProductQueryPort.findAllByCartId(cart.getId());

        return cartProducts.stream().
                map(c -> new MyCartProductResponse(c.getProductId(), c.getProductName(), c.getPrice()))
                .toList();
    }

    @Override
    @Transactional
    public void addProductInCart(String username, CartServiceAddRequest request) {

        Cart cart = cartQueryPort.findByUserId(username);
        if (cart == null) {
            cart = createCart(username);
        }

        CartProduct product = CartProduct.create(cart, request.getId(), request.getName(), request.getPrice());
        cartProductCommandPort.save(product);
    }

    public Cart createCart(String userId) {
        Cart cart = Cart.create(userId);
        em.persist(cart);
        em.flush();
        em.clear();
        return cart;
    }


}
