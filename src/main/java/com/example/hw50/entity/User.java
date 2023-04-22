package com.example.hw50.entity;

import com.example.hw50.util.Generator;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Random;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
    public class User implements UserDetails {

    private Long id;
    private String naame;
    private String username;
    private String email;
    private String password;
    private int publications;
    private int followings;
    private int followers;
    private boolean enabled;
    private String roles;

    public static User random(){
        Random rnd = new Random();
        return builder()
                .naame(Generator.makeName())
                .username(Generator.makeName())
                .email(Generator.makeEmail())
                .password("qwerty0")
                .publications(rnd.nextInt(5))
                .enabled(true)
                .roles("USER")
                .followings(rnd.nextInt(7) + 1)
                .followers(rnd.nextInt(7) +1)
                .build();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
