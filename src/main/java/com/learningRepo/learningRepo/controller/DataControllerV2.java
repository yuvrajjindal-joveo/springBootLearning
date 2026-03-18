package com.learningRepo.learningRepo.controller;

import com.learningRepo.learningRepo.entity.DataEntityV2;
import com.learningRepo.learningRepo.services.DataEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dataV2")
public class DataControllerV2 {

    @Autowired
    private DataEntryService dataEntryService;

    @GetMapping
    public ResponseEntity<?> getAllData(){
        try {
            return ResponseEntity.ok(dataEntryService.getAllData());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addDataEntry(@RequestBody DataEntityV2 reqData){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();

            dataEntryService.saveDataEntry(reqData, username);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDataEntry(@PathVariable ObjectId id){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();

            dataEntryService.deleteDataEntry(id, username);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }



}
