package com.example.myorder.api.mappers;

import com.example.myorder.api.dtos.CreateProductDto;
import com.example.myorder.api.dtos.ProductResponseDto;
import com.example.myorder.entities.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

	private static final ModelMapper modelMapper = new ModelMapper();

	public static Product toEntity(CreateProductDto createProductDto) {
		return modelMapper.map(createProductDto, Product.class);

	}

	public static ProductResponseDto toResponseDto(Product user) {
		return modelMapper.map(user, ProductResponseDto.class);

	}

}

