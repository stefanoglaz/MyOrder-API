package com.example.myorder.api.controller;

import com.example.myorder.api.RestPath;
import com.example.myorder.api.dtos.CreateProductDto;
import com.example.myorder.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("ProductController")
@RequestMapping(RestPath.BASE_PATH + "/product")
@Api(tags = "Produtos")
public class ProductController {

	@Autowired
	private ProductService service;

	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping
	@ApiResponses({
		@ApiResponse( code = 201, message = "Produto criado com sucesso" )})
	public void create(@RequestBody @Valid CreateProductDto dto){
		 service.createProduct( dto );
	}

}
