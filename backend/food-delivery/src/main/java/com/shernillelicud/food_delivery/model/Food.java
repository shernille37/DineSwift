package com.shernillelicud.food_delivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Long price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Restaurant restaurant;

    @Column(length = 1000)
    @ElementCollection
    private List<String> images = new ArrayList<>();

    private Boolean isAvailable;

    private Boolean isVegetarian;

    private Boolean isSeasonal;

    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    private Date createdAt;

}
