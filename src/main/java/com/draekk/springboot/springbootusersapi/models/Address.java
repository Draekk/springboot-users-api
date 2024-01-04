package com.draekk.springboot.springbootusersapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {

    private Long id;
    private String street;
    private String city;
    private String country;
}
