package com.example.tasks.Controller;

import com.example.tasks.Dto.AuthRequestDto;
import com.example.tasks.Dto.AuthResponseDto;
import com.example.tasks.Service.JwtService;
import com.example.tasks.Service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> createToken(@RequestBody AuthRequestDto authRequestDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword())
            );
        }
        catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        final UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(authRequestDto.getUsername());
        final String jwt = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponseDto(jwt, "Login exitoso", HttpStatus.OK));


    }

    @GetMapping("/view")
    public String publicView(){
        return "Hola mundo";
    }
}
