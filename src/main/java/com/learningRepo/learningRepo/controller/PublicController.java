package com.learningRepo.learningRepo.controller;

import com.learningRepo.learningRepo.entity.User;
import com.learningRepo.learningRepo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/createUser")
    public ResponseEntity<?> CreateNewUser(@RequestBody User user){

        Optional<User> exictingUser = userService.findUserByName(user.getUserName());

        if(exictingUser.isPresent()){
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("user already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList("user"));

        User savedUser = userService.saveNewUser(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }


}
