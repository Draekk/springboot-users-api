package com.draekk.springboot.springbootusersapi.repositories;

import java.util.ArrayList;
import java.util.List;

import com.draekk.springboot.springbootusersapi.models.Account;
import com.draekk.springboot.springbootusersapi.models.Address;
import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.UserDto;

public class UserRepositoryImpl implements IUserRepository {

    private List<User> users = List.of(
        new User(1L, "311513-2", "Gever", "Rodríguez", new Account(1L, "drakkseid", "THEHELL9000."), "rodriver1992@gmail.com", new Address(1L, "Jehova Yireh 1161", "Curacaví", "Chile")),
        new User(1L, "311513-2", "Andrea", "Rodríguez", new Account(1L, "drakkseid", "THEHELL9000."), "rodriver1992@gmail.com", new Address(1L, "Jehova Yireh 1161", "Curacaví", "Chile")),
                    new User(2L, "235624-1", "Laura", "Peralta", new Account(2L, "aluranyx", "qrgqrgjri3."), "alura.peralta.02@gmail.com", new Address(2L, "Jehova Yireh 1161", "Curacaví", "Chile")),
                    new User(3L, "235624-1", "Andres", "Peralta", new Account(3L, "aluranyx", "qrgqrgjri3."), "andres@correo.cl", new Address(3L, "Jehova Yireh 1161", "Curacaví", "Chile"))
        );

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void edit(UserDto user) {
        users.set(user.getIndex(), user.getUser());
    }

    @Override
    public void delete(UserDto user) {
        users.remove(user.getIndex());
    }

    @Override
    public User findById(Long id) {
        for(User user : users) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByDni(String dni) {
        for(User user : users) {
            if(user.getDni().equals(dni)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> usersByName = new ArrayList<>();
        for(User user : users) {
            if(user.getName().contains(name)){
                usersByName.add(user);
            }
        }
        return usersByName;
    }

    @Override
    public int count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public Long nextId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextId'");
    }

}
