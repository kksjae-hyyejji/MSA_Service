package shop.msa.cart.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.msa.cart.domain.Cart;
import shop.msa.cart.service.cqrs.CartQueryPort;
import shop.msa.cart.service.response.MyCartProductResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CartServiceImplTest {

    @Autowired
    CartServiceImpl cartService;

    @Autowired
    CartQueryPort cartQueryPort;

    @Test
    @DisplayName("최초 카트 조회시 카트가 없는 경우, 카트를 생성한다.")
    void createCartWhenThereIsNoCart() {

        String userId = "newUserId";
        Cart noCart = cartQueryPort.findByUserId(userId);

        List<MyCartProductResponse> list = cartService.getCartProducts("newUserId");
        Cart cart = cartQueryPort.findByUserId(userId);

        assertThat(noCart).isNull();
        assertThat(cart.getUserId()).isEqualTo(userId);

    }

}