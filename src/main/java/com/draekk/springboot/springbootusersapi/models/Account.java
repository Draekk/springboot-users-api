package com.draekk.springboot.springbootusersapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Account {

    private Long id;
    private String username;
    private String password;
}
