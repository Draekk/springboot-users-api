package com.draekk.springboot.springbootusersapi.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private UserIndexDto user;
    private String status;
    private String message;
}
