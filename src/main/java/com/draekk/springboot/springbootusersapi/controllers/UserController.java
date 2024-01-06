package com.draekk.springboot.springbootusersapi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.ResponseDto;
import com.draekk.springboot.springbootusersapi.models.dtos.UserResponseDto;
import com.draekk.springboot.springbootusersapi.services.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private IUserService service;

    @PostMapping("/add")
    public UserResponseDto addUser(@RequestBody Map<String, String> json) {
        return service.save(json);
    }

    @PutMapping("/edit/{id}")
    public UserResponseDto editUser(@PathVariable int id, @RequestBody Map<String, String> json) {
        return service.edit(id, json);
    }

    @GetMapping("/list")
    public List<User> userlist() {
        return service.findAll();
    }

    @GetMapping("/find/id/{id}")
    public User userFindById(@PathVariable Integer id) {
        return service.findById(id.longValue());
    }
    
    @GetMapping("/find/dni")
    public User userFindByDni(@RequestBody Map<String, String> json) {
        return service.findByDni(json.get("dni"));
    }

    @GetMapping("/find/name")
    public List<User> userFindByName(@RequestBody Map<String, String> json) {
        return service.findByName(json.get("name"));
    }

    @DeleteMapping("/destroy/{id}")
    public ResponseDto userDestroy(@PathVariable int id) {
        return service.delete(id);
    }
}
