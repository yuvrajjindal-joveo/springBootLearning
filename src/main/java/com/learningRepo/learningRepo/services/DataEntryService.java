package com.learningRepo.learningRepo.services;

import com.learningRepo.learningRepo.entity.DataEntityV2;
import com.learningRepo.learningRepo.repository.DataEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataEntryService {

    @Autowired
    private DataEntryRepository dataEntryRepository;


    public void saveDataEntry(DataEntityV2 data){
        dataEntryRepository.save(data);
    }

    public List<DataEntityV2> getAllData(){
        return dataEntryRepository.findAll();
    }

}
