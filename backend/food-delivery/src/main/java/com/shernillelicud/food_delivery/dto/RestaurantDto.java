package com.shernillelicud.food_delivery.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Embeddable
public class RestaurantDto {

    private Long id;

    private String name;

    @Column(length = 1000)
    private List<String> images = new ArrayList<>();

    private String description;


}
