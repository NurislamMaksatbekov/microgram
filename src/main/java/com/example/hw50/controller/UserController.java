package com.example.hw50.controller;

import com.example.hw50.dto.UserDto;
import com.example.hw50.entity.User;
import com.example.hw50.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/findbyname")
    public UserDto findByName(@RequestParam String name) {
        return userService.findByName(name);
    }

    @GetMapping("/findbyusername")
    public UserDto findByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/findbyemail")
    public UserDto findByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/checkuserexist")
    public UserDto ifUserExist(@RequestParam String email) {
        return userService.ifUserExist(email);
    }

    @PostMapping("/register")
    public UserDto addNewUser(@RequestBody UserDto user){
        return userService.addUser(user);
    }
}
