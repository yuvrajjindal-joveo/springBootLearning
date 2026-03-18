package com.learningRepo.learningRepo.controller;

import com.learningRepo.learningRepo.entity.User;
import com.learningRepo.learningRepo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userService.findUserByName(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username: " + username)
                );

        user.setEmail(request.getEmail());

        if (!request.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        userService.saveNewUser(user);

        return ResponseEntity.ok("User updated successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.allUsers());
    }


}
