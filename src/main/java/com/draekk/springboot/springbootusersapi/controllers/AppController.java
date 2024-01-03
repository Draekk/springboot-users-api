package com.draekk.springboot.springbootusersapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.draekk.springboot.springbootusersapi.models.User;
import com.draekk.springboot.springbootusersapi.services.IUserService;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    @Qualifier("userService")
    private IUserService service;

    @GetMapping({"/userlist", "/userlist/"})
    public List<User> userlist() {
        return service.findAll();
    }
}
