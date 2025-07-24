package com.example.tasks.Service;

import com.example.tasks.Dto.CreateUserResponseDto;
import com.example.tasks.Entity.User;
import com.example.tasks.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.CREATED;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    //Crear usuario
    public CreateUserResponseDto createUser(User user){

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        CreateUserResponseDto response = new CreateUserResponseDto();

        response.setMessage("Usuario creado exitosamente");
        response.setStatus(CREATED);

        return response;

    }

}
