package com.shernillelicud.food_delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Cart cart;

    @OneToOne
    private Food food;

    private List<Ingredient> ingredients;

    private Integer quantity;

    private Long totalPrice;

    public Long calculateTotalPrice() {
        this.totalPrice = food.getPrice() * quantity;

        return this.totalPrice;
    }

}
