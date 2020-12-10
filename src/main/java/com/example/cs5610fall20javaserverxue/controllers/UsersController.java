package com.example.cs5610fall20javaserverxue.controllers;

import com.example.cs5610fall20javaserverxue.models.User;
import com.example.cs5610fall20javaserverxue.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UsersController {

    @Autowired
    UsersService service;


    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

//    @GetMapping("/api/users/{userId}")
//    public User findUserByID (@PathVariable("userId")Integer userId) {
//        return service.findUserByID(userId);
//    }

    @GetMapping("/api/users/{username}")
    public User findUserByUsername (@PathVariable("username")String username) {
        return service.findUserByUsername(username);
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("/api/users/{userId}")
    public User updateUser(@PathVariable("userId") Integer userId, @RequestBody User newUser) {
        return service.updateUser(userId, newUser);
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        service.deleteUser(userId);

    }
}
