package ru.diasoft.user_mvc_webservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.diasoft.user_mvc_webservice.entities.User;
import ru.diasoft.user_mvc_webservice.exceptions.UserNotFoundException;
import ru.diasoft.user_mvc_webservice.services.UserService;

@RestController
@RequestMapping(path = "")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users")
    public List<User> getUserList() {
        return userService.getUsersList();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        return user;
    }

    @PostMapping("/save")
    public void addUser(@RequestBody User user) {
        userService.add(user);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.removeUser(id);
    }
}
