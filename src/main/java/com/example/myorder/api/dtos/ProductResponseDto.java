package com.example.myorder.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@ApiModel(value = "Objeto de resposta de produto")
public class ProductResponseDto {

	@NotNull
	@ApiModelProperty(value= "${product.create.name}")
	private String name;

	@NotNull
	@ApiModelProperty(value= "${product.create.value}")
	private BigDecimal value;

	@NotNull
	@ApiModelProperty(value= "${product.create.restaurant}")
	private RestaurantResponseDto restaurant;

	public String getName() {
		return name;
	}

	public ProductResponseDto setName(String name) {
		this.name = name;
		return this;
	}

	public BigDecimal getValue() {
		return value;
	}

	public ProductResponseDto setValue(BigDecimal value) {
		this.value = value;
		return this;
	}

	public RestaurantResponseDto getRestaurant() {
		return restaurant;
	}

	public ProductResponseDto setRestaurant(RestaurantResponseDto restaurant) {
		this.restaurant = restaurant;
		return this;
	}
}
