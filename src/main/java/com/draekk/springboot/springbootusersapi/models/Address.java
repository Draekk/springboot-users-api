package com.draekk.springboot.springbootusersapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Address {

    private Long id;
    private String street;
    private String city;
    private String country;
}
