package com.learningRepo.learningRepo.controller;

import com.learningRepo.learningRepo.entity.DataEntity;
import com.learningRepo.learningRepo.entity.DataEntityV2;
import com.learningRepo.learningRepo.services.DataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> addData(@RequestBody DataEntityV2 reqData){
        try{
            dataEntryService.saveDataEntry(reqData);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
