package com.data.session12_2.service;


import com.data.session12_2.model.entity.User;
import com.data.session12_2.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface userService {

    User register(String username, String password);
    static User login(String username, String password);
    User findByUsername(String username);
}