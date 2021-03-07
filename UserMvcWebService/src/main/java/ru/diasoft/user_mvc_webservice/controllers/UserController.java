package ru.diasoft.user_mvc_webservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.diasoft.user_mvc_webservice.entities.User;
import ru.diasoft.user_mvc_webservice.services.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @GetMapping
    public List<User> check() {
        return userService.getUsersList();
    }
}
