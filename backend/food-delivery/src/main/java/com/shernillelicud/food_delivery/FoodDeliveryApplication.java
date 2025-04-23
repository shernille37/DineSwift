package com.shernillelicud.food_delivery;

import com.shernillelicud.food_delivery.config.Env;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodDeliveryApplication {

	public static void main(String[] args) {
		new Env().loadEnv();
		SpringApplication.run(FoodDeliveryApplication.class, args);
	}

}
