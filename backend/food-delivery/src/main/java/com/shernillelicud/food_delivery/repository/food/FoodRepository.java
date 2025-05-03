package com.shernillelicud.food_delivery.repository.food;

import com.shernillelicud.food_delivery.model.Category;
import com.shernillelicud.food_delivery.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByRestaurantId(Long id);

    List<Food> findByIsSeasonalTrue();

    List<Food> findByIsVegetarianTrue();

    List<Food> findByCategoryName(String category);


    @Query("SELECT f FROM Food f WHERE f.name LIKE %:keyword% OR f.category.name LIKE %:keyword%")
    List<Food> searchFood(@Param("keyword") String keyword);
}
