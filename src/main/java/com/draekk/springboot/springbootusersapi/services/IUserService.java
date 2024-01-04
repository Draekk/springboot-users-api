package com.draekk.springboot.springbootusersapi.services;

import java.util.List;
import java.util.Map;

import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.UserIndexDto;

public interface IUserService {

    void save(Map<String, String> json);
    void edit(User user);
    void delete(User user);
    User findById(Long id);
    User findByDni(String dni);
    List<User> findAll();
    List<User> findByName(String name);
    int count();
    Long nextId();
    UserIndexDto createDto(User user);
}
