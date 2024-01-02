package com.draekk.springboot.springbootusersapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Long id;
    private String dni;
    private String name;
    private String lastname;
    private Account account;
    private String email;
    private Address address;
}
