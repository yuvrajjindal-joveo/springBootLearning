package com.learningRepo.learningRepo.controller;

import com.learningRepo.learningRepo.entity.User;
import com.learningRepo.learningRepo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User userData){
        userService.saveUser(userData);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity<?> updateUser(@RequestBody User userData){
        User user = userService.findUserByName(userData.getUserName());
        if(user != null){
            user.setUserName(userData.getUserName());
            user.setEmail(userData.getEmail());
            user.setPassword(userData.getPassword());

            userService.saveUser(user);
        } else {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.allUsers());
    }


}
