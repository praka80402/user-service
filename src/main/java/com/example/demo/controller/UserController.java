package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Page<User> getUsers(@RequestParam int page, @RequestParam int size) {
        return userService.getUsersPage(page, size);
    }

    @GetMapping("/find")
    public User getUserByIdAndEmail(@RequestParam Long id, @RequestParam String email) {
        return userService.getUserByIdAndEmail(id, email);
    }
}
