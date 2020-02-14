package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateProductDto;
import com.example.myorder.api.mappers.ProductMapper;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.exception.NotFoundException;
import com.example.myorder.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private RestaurantService restaurantService;

	public void createProduct(CreateProductDto dto){
		Restaurant restaurant = restaurantService.findById( dto.getRestaurantId() );
		if(restaurant ==null)
			throw new NotFoundException( "Restaurante não encontrado com o id: " + dto.getRestaurantId() );
		productRepository.save( ProductMapper.toEntity( dto ).setRestaurant( restaurant ) );

	}
}
