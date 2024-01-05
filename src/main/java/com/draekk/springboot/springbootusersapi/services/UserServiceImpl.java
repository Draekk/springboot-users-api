package com.draekk.springboot.springbootusersapi.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.draekk.springboot.springbootusersapi.models.Account;
import com.draekk.springboot.springbootusersapi.models.Address;
import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.ResponseDto;
import com.draekk.springboot.springbootusersapi.models.dtos.UserResponseDto;
import com.draekk.springboot.springbootusersapi.repositories.IRepository;
import com.draekk.springboot.springbootusersapi.utils.PasswordEncrypterUtil;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("userRepository")
    IRepository<User> repository;

    @Override
    public UserResponseDto save(Map<String, String> json) {
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

        return response(findById(nextId() - 1), HttpStatus.CREATED.value());
    }

    @Override
    public UserResponseDto edit(Integer id, Map<String, String> json) {
        User user = (User)repository.findById(id.longValue());
        if(user != null) {
            json.forEach((key, value) -> {
                if(value != null) {
                    switch(key) {
                        case "dni":
                            user.setDni(value);
                            break;
                        case "name":
                            user.setName(value);
                            break;
                        case "lastname":
                            user.setLastname(value);
                            break;
                        case "email":
                            user.setEmail(value);
                            break;
                        case "username":
                            user.getAccount().setUsername(value);
                            break;
                        case "password":
                            PasswordEncrypterUtil encrypter = new PasswordEncrypterUtil();
                            user.getAccount().setPassword(encrypter.encrypt(value));
                            break;
                        case "street":
                            user.getAddress().setStreet(value);
                            break;
                        case "city":
                            user.getAddress().setCity(value);
                            break;
                        case "country":
                            user.getAddress().setCountry(value);
                            break;
                    }
                }
            });
            repository.edit(user);
            
            return response(findById(user.getId()), HttpStatus.ACCEPTED.value());
        }
        return response(user, HttpStatus.NOT_FOUND.value());
    }

    @Override
    public ResponseDto delete(Integer id) {
        User user = findById(id.longValue());

        if(user != null) {
            repository.delete(user);
            return new ResponseDto("delete", HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        }
        return new ResponseDto("delete", HttpStatus.NOT_FOUND.value(), "User not found");
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User findByDni(String dni) {
        return repository.findByStr(dni);
    }

    @Override
    public List<User> findAll() {
        List<User> users = (List<User>)repository.findAll();
        return users;
    }

    @Override
    public List<User> findByName(String name) {
        return repository.findByStrList(name);
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
    public UserResponseDto response(User user, int status) {
        UserResponseDto response = new UserResponseDto();
        response.setUser(user);
        response.setStatus(status);
        
        if(status >= 200 && status < 300) {
            response.setMessage("Transaction successful");
        } else {
            response.setMessage("Transaction error");
        }

        return response;
    }

}
