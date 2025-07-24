package com.example.tasks.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CreateUserResponseDto {

    private String message;

    private HttpStatus status;
}
