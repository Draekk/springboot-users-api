package com.draekk.springboot.springbootusersapi.models.dtos;

import com.draekk.springboot.springbootusersapi.models.Account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccountDto {

    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return account.getId();
    }

    public String getUsername() {
        return account.getUsername();
    }
}
