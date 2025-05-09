package com.shernillelicud.food_delivery.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class ApiResponse {

    private String message;
    private Object data;

}
