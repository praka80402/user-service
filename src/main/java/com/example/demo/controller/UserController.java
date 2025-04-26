package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Page<User> getUsers(@RequestParam int page, @RequestParam int size) {
        return userService.getUsersPage(page, size);
    }

    @GetMapping("/find")
    public User getUserByIdAndEmail(
            @RequestParam @Min(value = 1, message = "ID Should be Positive") Long id,
            @RequestParam @Email(message = "Incorrect Email!") String email) {

        return userService.getUserByIdAndEmail(id, email);
    }

    @GetMapping("/find-by-email")
    public User findUserByEmail(@RequestParam @Email(message = "Sahi email daal bhai!") String email) {
        return userService.findUserByEmailUsingProcedure(email);
    }
}
