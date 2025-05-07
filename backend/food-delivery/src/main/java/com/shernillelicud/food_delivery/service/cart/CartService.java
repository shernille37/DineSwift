package com.shernillelicud.food_delivery.service.cart;


import com.shernillelicud.food_delivery.exception.CartItemNotFoundException;
import com.shernillelicud.food_delivery.exception.CartNotFoundException;
import com.shernillelicud.food_delivery.exception.FoodNotFoundException;
import com.shernillelicud.food_delivery.model.Cart;
import com.shernillelicud.food_delivery.model.CartItem;
import com.shernillelicud.food_delivery.model.Food;
import com.shernillelicud.food_delivery.model.User;
import com.shernillelicud.food_delivery.repository.cart.CartItemRepository;
import com.shernillelicud.food_delivery.repository.cart.CartRepository;
import com.shernillelicud.food_delivery.repository.food.FoodRepository;
import com.shernillelicud.food_delivery.request.cart.NewCartItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService{

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final FoodRepository foodRepository;


    @Override
    public CartItem addToCart(NewCartItemRequest request, User customer) {

        Optional<Cart> cart = cartRepository.findByCustomer(customer);

        Food food = foodRepository.findById(request.getFood().getId())
                .orElseThrow(FoodNotFoundException::new);

        CartItem newCartItem = CartItem.builder()
                .food(food)
                .quantity(request.getQuantity())
                .ingredients(request.getIngredients())
                .build();

//        The user has no existing carts in the database
        if(cart.isEmpty()) {

            Cart newCart = Cart.builder()
                    .customer(customer)
                    .build();

            newCartItem.setCart(newCart);

            newCart.getCartItems().add(newCartItem);

            cartRepository.save(newCart);

        } else {

            cart.get().getCartItems().add(newCartItem);

            newCartItem.setCart(cart.get());

            cartRepository.save(cart.get());
        }


        return cartItemRepository.save(newCartItem);

    }

    @Override
    public CartItem updateCartItemQuantity(Long id, NewCartItemRequest request) {

        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(CartItemNotFoundException::new);

        cartItem.setQuantity(request.getQuantity());

        return cartItemRepository.save(cartItem);
    }

    @Override
    public Cart removeFromCart(Long id, User customer) {

        Cart cart = cartRepository.findByCustomer(customer)
                .orElseThrow(CartItemNotFoundException::new);

        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(CartItemNotFoundException::new);

        cart.getCartItems().remove(cartItem);
        cartItemRepository.delete(cartItem);

        return cartRepository.save(cart);
    }

    @Override
    public Long calculateTotalPrice(Cart cart) {
        Long totalPrice = 0L;

        for(CartItem item : cart.getCartItems()) {
            totalPrice += item.calculateTotalPrice();
        }

        return totalPrice;
    }

    @Override
    public Cart clearCart(User customer) {

        Cart cart = cartRepository.findByCustomer(customer)
                .orElseThrow(CartNotFoundException::new);

        for(CartItem item : cart.getCartItems()) {
            cart = removeFromCart(item.getId(), customer);
        }

        return cart;
    }
}
