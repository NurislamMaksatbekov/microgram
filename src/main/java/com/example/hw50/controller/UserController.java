package com.example.hw50.controller;

import com.example.hw50.entity.User;
import com.example.hw50.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/findbyname")
    public Optional<User> findByName(@RequestParam String name) {
        return userService.findByName(name);
    }

    @GetMapping("/findbyusername")
    public Optional<User> findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/findbyemail")
    public Optional<User> findByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/checkuserexist")
    public Optional<User> ifUserExist(@RequestParam String email) {
        return userService.ifUserExist(email);
    }
}
