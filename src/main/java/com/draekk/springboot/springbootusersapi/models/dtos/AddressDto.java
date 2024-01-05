package com.draekk.springboot.springbootusersapi.models.dtos;

import com.draekk.springboot.springbootusersapi.models.Address;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddressDto {

    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return address.getId();
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getCity() {
        return address.getCity();
    }

    public String getCountry() {
        return address.getCountry();
    }
}
