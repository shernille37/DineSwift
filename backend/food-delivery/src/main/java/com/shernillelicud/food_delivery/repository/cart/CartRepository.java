package com.shernillelicud.food_delivery.repository.cart;

import com.shernillelicud.food_delivery.model.Cart;
import com.shernillelicud.food_delivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByCustomer(User customer);

}
