package com.learningRepo.learningRepo.controller;

import com.learningRepo.learningRepo.entity.DataEntity;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class DataController {

    private Map<Long, DataEntity> dataList = new HashMap<>();

    @GetMapping
    public List<DataEntity> getAllData(){
        return new ArrayList<>(dataList.values());
    }

    @PostMapping
    public boolean addData(@RequestBody DataEntity reqData){
        dataList.put(reqData.getId() , reqData);
        return true;
    }

    @GetMapping("/id/{id}")
    public DataEntity getDataById(@PathVariable Long id){
        return dataList.get(id);
    }

    @DeleteMapping("/id/{id}")
    public void DeleteData(@PathVariable Long id){
        dataList.remove(id);
    }

    @GetMapping("/type/{type}")
    public List<DataEntity> getDataByType(@PathVariable String type){
        List<DataEntity> selectedDataByType = new ArrayList<DataEntity>();
        dataList.forEach((key,value) -> {
            if(value.getType().equals(type)) selectedDataByType.add(value);
        } );

        return selectedDataByType;
    }

    @PutMapping("/id/{id}")
    public void updateDataById(@PathVariable Long id, @RequestBody DataEntity reqData){
        dataList.put(id,reqData);
    }
}
