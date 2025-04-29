package com.shernillelicud.food_delivery.repository;

import com.shernillelicud.food_delivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
