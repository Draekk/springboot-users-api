package com.draekk.springboot.springbootusersapi.repositories;

import java.util.List;

import com.draekk.springboot.springbootusersapi.models.User;

public interface IUserRepository {

    void save(User user);
    void edit(User user);
    void delete(User user);
    User findById(Long id);
    User findByDni(String dni);
    List<User> findAll();
    List<User> findByName(String name);
    int count();
    Long nextId();
}
