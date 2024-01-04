package com.draekk.springboot.springbootusersapi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.models.dtos.UserResponseDto;
import com.draekk.springboot.springbootusersapi.services.IUserService;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    @Qualifier("userService")
    private IUserService service;

    @PostMapping("/user/add")
    public UserResponseDto addUser(@RequestBody Map<String, String> json) {
        return service.save(json);
    }

    @PutMapping("/user/edit/{id}")
    public UserResponseDto editUser(@PathVariable int id, @RequestBody Map<String, String> json) {
        return service.edit(id, json);
    }

    @GetMapping("/user/list")
    public List<User> userlist() {
        return service.findAll();
    }
}
