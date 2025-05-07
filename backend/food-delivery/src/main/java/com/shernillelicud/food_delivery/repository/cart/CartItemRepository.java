package com.shernillelicud.food_delivery.repository.cart;

import com.shernillelicud.food_delivery.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
