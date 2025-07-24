package com.example.tasks.Controller;

import com.example.tasks.Dto.CreateUserDto;
import com.example.tasks.Dto.CreateUserResponseDto;
import com.example.tasks.Entity.User;
import com.example.tasks.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CreateUserResponseDto createUser(@RequestBody CreateUserDto CreateUserDto){
        User user = new User (CreateUserDto.getUsername(), CreateUserDto.getPassword());
        return userService.createUser(user);
    }
}
