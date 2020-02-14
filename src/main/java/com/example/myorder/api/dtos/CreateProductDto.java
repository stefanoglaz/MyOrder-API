package com.example.myorder.api.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@ApiModel(value = "Objeto de criação de produto")
public class CreateProductDto {

	@NotNull
	@ApiModelProperty(value= "${product.create.name}")
	@Size(min = 3)
	private String name;

	@NotNull
	@ApiModelProperty(value= "${product.create.value}")
	@Min( value = 1, message = "Valor deve ser no mínimo 1")
	private BigDecimal value;

	@NotNull
	@ApiModelProperty(value= "${product.create.restaurantId}")
	private Integer restaurantId;

	public String getName() {
		return name;
	}

	public CreateProductDto setName(String name) {
		this.name = name;
		return this;
	}

	public BigDecimal getValue() {
		return value;
	}

	public CreateProductDto setValue(BigDecimal value) {
		this.value = value;
		return this;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public CreateProductDto setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
		return this;
	}
}
