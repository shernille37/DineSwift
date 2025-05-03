package com.shernillelicud.food_delivery.repository.food;

import com.shernillelicud.food_delivery.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
