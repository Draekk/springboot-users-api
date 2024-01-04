package com.draekk.springboot.springbootusersapi.repositories;

import java.util.List;

import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.UserIndexDto;

public interface IUserRepository {

    void save(User user);
    void edit(UserIndexDto user);
    void delete(UserIndexDto user);
    User findById(Long id);
    User findByDni(String dni);
    List<User> findAll();
    List<User> findByName(String name);
    int count();
    Long nextId();
}
