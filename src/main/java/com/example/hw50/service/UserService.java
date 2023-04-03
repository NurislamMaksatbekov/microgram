package com.example.hw50.service;

import com.example.hw50.dao.UserDao;
import com.example.hw50.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public Optional<User> findByName(String name){
        return userDao.findByName(name);
    }

    public Optional<User> findByUsername(String username){
        return userDao.findByUsername(username);
    }

    public Optional<User> findByEmail(String email){
        return userDao.findByEmail(email);
    }

    public Optional<User> ifUserExist(String email){
        return userDao.ifUserExist(email);
    }

}
