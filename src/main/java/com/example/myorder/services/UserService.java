package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateUserDto;
import com.example.myorder.api.dtos.UserResponseDto;
import com.example.myorder.api.mappers.UserMapper;
import com.example.myorder.entities.User;
import com.example.myorder.exception.AlreadyExistsException;
import com.example.myorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDto create(CreateUserDto createUserDto) {
        validateUseEmail( createUserDto.getEmail() );
        User user = userRepository.save( createUser( createUserDto ));
        return UserMapper.toResponseDto( user ) ;
    }


    private User createUser(CreateUserDto dto){
        return new User()
                .setEmail( dto.getEmail() )
                .setName( dto.getName() )
                .setAdress( dto.getAddress() )
                .setPassword( dto.getPassword() )
                .setPhone( dto.getPhone() );
    }

    private void validateUseEmail(String email){
        User user =userRepository.findByEmail( email );
        if(user != null)
            throw new AlreadyExistsException( "já existe um usuário cadastrado com este e-mail" );


    }

}
