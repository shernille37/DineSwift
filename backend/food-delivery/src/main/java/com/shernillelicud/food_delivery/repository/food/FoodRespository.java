package com.shernillelicud.food_delivery.repository.food;

import com.shernillelicud.food_delivery.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRespository extends JpaRepository<Food, Long> {

}
