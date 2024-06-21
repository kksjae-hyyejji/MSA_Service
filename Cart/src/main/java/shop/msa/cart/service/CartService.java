package shop.msa.cart.service;

import shop.msa.cart.service.request.CartServiceAddRequest;
import shop.msa.cart.service.response.MyCartProductResponse;

import java.util.List;

public interface CartService {

    List<MyCartProductResponse> getCartProducts(String userId);

    void addProductInCart(String username, CartServiceAddRequest serviceRequest);
}
