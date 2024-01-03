package com.draekk.springboot.springbootusersapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.UserDto;
import com.draekk.springboot.springbootusersapi.repositories.IUserRepository;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("userRepository")
    IUserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void edit(User user) {
        repository.edit(createDto(user));
    }

    @Override
    public void delete(User user) {
        repository.delete(createDto(user));
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User findByDni(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public int count() {
        return repository.count();
    }

    @Override
    public Long nextId() {
        return repository.nextId();
    }

    @Override
    public UserDto createDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setIndex(repository.findAll().indexOf(user));
        return userDto;
    }

}
