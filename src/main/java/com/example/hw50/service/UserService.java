package com.example.hw50.service;

import com.example.hw50.dao.UserDao;
import com.example.hw50.dto.UserDto;
import com.example.hw50.entity.User;
import com.example.hw50.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserDao userDao;

    public UserDto findByName(String name){
        var user = userDao.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the name like " + name));
        return  UserDto.from(user);

    }

    public UserDto findByUsername(String username){
        var user = userDao.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the username like " + username));
        return UserDto.from(user);

    }

    public UserDto findByEmail(String email){
        var user = userDao.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the username like " + email));
        return UserDto.from(user);
    }

    public UserDto ifUserExist(String email){
        var user =  userDao.ifUserExist(email)
                .orElseThrow(() -> new ResourceNotFoundException("There aren't any users with email like " + email));
        return UserDto.from(user);
    }

    public UserDto addUser(UserDto userData){
        var user = User.builder()
                .naame(userData.getNaame())
                .username(userData.getUsername())
                .email(userData.getUsername())
                .password(userData.getPassword())
                .build();

        userDao.save(user);
        return UserDto.from(user);
    }

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userDao.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User was not found");
        }
        return user.get();
    }

}
