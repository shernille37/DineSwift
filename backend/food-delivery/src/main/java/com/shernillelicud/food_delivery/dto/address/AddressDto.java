package com.shernillelicud.food_delivery.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;

    private String street;

    private String city;

    private String state;

    private String zip;

}
