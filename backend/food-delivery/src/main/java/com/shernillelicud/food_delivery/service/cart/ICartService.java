package com.shernillelicud.food_delivery.service.cart;

import com.shernillelicud.food_delivery.model.Cart;
import com.shernillelicud.food_delivery.model.CartItem;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.request.cart.NewCartItemRequest;

public interface ICartService {

    public CartItem addToCart(NewCartItemRequest request, User customer);

    public CartItem updateCartItemQuantity(Long id, NewCartItemRequest request);

    public Cart removeFromCart(Long id, User customer);

    public Long calculateTotalPrice(Cart cart);

    public Cart clearCart(User customer);

}
