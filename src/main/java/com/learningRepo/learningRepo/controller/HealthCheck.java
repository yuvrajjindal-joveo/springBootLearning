package com.learningRepo.learningRepo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HealthCheck {

    @GetMapping("/heath-check")
    public String isHealty(){
        return "ok";
    }
}
