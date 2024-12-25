package com.sathya.SpringBoot.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class ProductModel {
    @NotBlank(message = "product name cannot be blank")
	private String name;
    @NotBlank(message = "Brand cannot be blank")
	private String brand;
    @NotBlank(message = "made-in field cannot be blank")
	private String madeIn;
    @Positive(message = "price must be greater than zero")
	private double price;
    @Min(value = 1,message = "Qunatity must be atleast one")
	private int quantity;
    @DecimalMax(value = "100.0",message = "Discount rate cannot exceed 100")
	private double discountrate;
	private double taxprice;
}
