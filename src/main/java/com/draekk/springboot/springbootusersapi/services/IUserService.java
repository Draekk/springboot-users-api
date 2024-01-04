package com.draekk.springboot.springbootusersapi.services;

import java.util.List;
import java.util.Map;

import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.UserResponseDto;

public interface IUserService {

    UserResponseDto save(Map<String, String> json);
    UserResponseDto edit(Integer id, Map<String, String> json);
    void delete(User user);
    User findById(Long id);
    User findByDni(String dni);
    List<User> findAll();
    List<User> findByName(String name);
    int count();
    Long nextId();
    UserResponseDto response(User user, int status);
}
