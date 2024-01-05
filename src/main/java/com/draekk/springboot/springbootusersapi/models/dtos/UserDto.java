package com.draekk.springboot.springbootusersapi.models.dtos;

import com.draekk.springboot.springbootusersapi.models.User;

public class UserDto {

    private User user;
    private AccountDto account;
    private AddressDto address;

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return user.getId();
    }

    public String getDni() {
        return user.getDni();
    }

    public String getName() {
        return user.getName();
    }

    public String getLastname() {
        return user.getLastname();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public AccountDto getAccount() {
        return account;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
