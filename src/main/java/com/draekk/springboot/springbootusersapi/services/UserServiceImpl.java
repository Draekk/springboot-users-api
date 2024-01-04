package com.draekk.springboot.springbootusersapi.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.draekk.springboot.springbootusersapi.models.Account;
import com.draekk.springboot.springbootusersapi.models.Address;
import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.UserIndexDto;
import com.draekk.springboot.springbootusersapi.repositories.IUserRepository;
import com.draekk.springboot.springbootusersapi.utils.PasswordEncrypterUtil;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("userRepository")
    IUserRepository repository;

    @Override
    public void save(Map<String, String> json) {
        PasswordEncrypterUtil encrypter = new PasswordEncrypterUtil();
        User user = new User();
        user.setId(repository.nextId());
        user.setDni(json.get("dni"));
        user.setName(json.get("name"));
        user.setLastname(json.get("lastname"));
        user.setEmail(json.get("email"));
        
        Account account = new Account();
        account.setId(user.getId());
        account.setUsername(json.get("username"));
        account.setPassword(encrypter.encrypt(json.get("password")));

        Address address = new Address();
        address.setId(user.getId());
        address.setStreet(json.get("street"));
        address.setCity(json.get("city"));
        address.setCountry(json.get("country"));

        user.setAccount(account);
        user.setAddress(address);

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
    public UserIndexDto createDto(User user) {
        UserIndexDto userDto = new UserIndexDto();
        userDto.setUser(user);
        userDto.setIndex(repository.findAll().indexOf(user));
        return userDto;
    }

}
