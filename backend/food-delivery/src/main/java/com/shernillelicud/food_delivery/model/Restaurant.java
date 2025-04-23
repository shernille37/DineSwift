package com.shernillelicud.food_delivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {

    public record Contact(String email, String mobile, String twitter, String instagram){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    private String name;

    @ManyToOne
    private User owner;

    private String description;

    private String cuisineType;

    @OneToOne
    private Address address;

    private Contact contact;

    private String openingHours;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    @Column(length = 1000)
    private List<String> images;
    
    private LocalDateTime registrationDate;
}
