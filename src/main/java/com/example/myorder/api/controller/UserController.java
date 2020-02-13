package com.example.myorder.api.controller;

import com.example.myorder.api.RestPath;
import com.example.myorder.api.dtos.CreateUserDto;
import com.example.myorder.api.dtos.UserResponseDto;
import com.example.myorder.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(RestPath.BASE_PATH + "/user")
@Api(tags = "Usuarios")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponseDto  createUser(@ApiParam("Objeto que contém informações do usuário") @RequestBody @Valid
			CreateUserDto createUserDto) {
		return userService.create( createUserDto );
	}

	@GetMapping(value = "/list")
	@ResponseStatus(HttpStatus.OK)
	public List<UserResponseDto> getUsers(){
		return userService.getUsers();
	}

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public UserResponseDto getUserById(@RequestParam @Param("id") Integer id){
		return userService.findById( id );
	}

}
