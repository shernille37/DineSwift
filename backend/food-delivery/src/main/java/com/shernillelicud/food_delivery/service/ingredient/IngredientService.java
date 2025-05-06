package com.shernillelicud.food_delivery.service.ingredient;

import com.shernillelicud.food_delivery.exception.CategoryNotFoundException;
import com.shernillelicud.food_delivery.model.Ingredient;
import com.shernillelicud.food_delivery.model.IngredientCategory;
import com.shernillelicud.food_delivery.repository.food.IngredientCategoryRepository;
import com.shernillelicud.food_delivery.repository.food.IngredientRepository;
import com.shernillelicud.food_delivery.request.ingredient.NewIngredientRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService implements IIngredientService{

    private final IngredientRepository ingredientRepository;
    private final IngredientCategoryRepository ingredientCategoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Ingredient createIngredient(NewIngredientRequest request) {

        IngredientCategory ingredientCategory = ingredientCategoryRepository.findById(request.getIngredientCategory().getId())
                .orElseThrow(CategoryNotFoundException::new);

        Ingredient newIngredient = modelMapper.map(request, Ingredient.class);

        newIngredient.setCategory(ingredientCategory);
        ingredientCategory.getIngredients().add(newIngredient);

        ingredientCategoryRepository.save(ingredientCategory);

        return ingredientRepository.save(newIngredient);
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
