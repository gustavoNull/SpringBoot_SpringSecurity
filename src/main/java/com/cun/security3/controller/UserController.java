package com.cun.security3.controller;

import com.cun.security3.entity.User;
import com.cun.security3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder encoder;

    @PostMapping("add")
    public User addUser(@RequestBody User user) {
        String password = user.getPassword();
        user.setPassword(encoder.encode(password.trim()));
        return userRepository.save(user);
    }

    @GetMapping("get")
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
