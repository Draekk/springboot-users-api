package com.draekk.springboot.springbootusersapi.repositories;

import java.util.List;

import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.UserDto;

public interface IUserRepository {

    void save(User user);
    void edit(UserDto user);
    void delete(UserDto user);
    User findById(Long id);
    User findByDni(String dni);
    List<User> findAll();
    List<User> findByName(String name);
    int count();
    Long nextId();
}
