package com.draekk.springboot.springbootusersapi.services;

import java.util.List;

import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.UserDto;

public interface IUserService {

    void save(User user);
    void edit(User user);
    void delete(User user);
    User findById(Long id);
    User findByDni(String dni);
    List<User> findAll();
    List<User> findByName(String name);
    int count();
    Long nextId();
    UserDto createDto(User user);
}
