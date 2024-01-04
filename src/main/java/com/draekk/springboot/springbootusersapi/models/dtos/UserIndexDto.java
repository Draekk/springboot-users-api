package com.draekk.springboot.springbootusersapi.models.dtos;

import com.draekk.springboot.springbootusersapi.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserIndexDto {
    private User user;
    private int index;
}
