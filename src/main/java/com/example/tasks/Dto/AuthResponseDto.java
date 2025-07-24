package com.example.tasks.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class AuthResponseDto {

    private String jwtToken;

    private String message;

    private HttpStatus status;


}
