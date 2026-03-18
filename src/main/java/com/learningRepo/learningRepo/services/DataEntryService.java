package com.learningRepo.learningRepo.services;

import com.learningRepo.learningRepo.entity.DataEntityV2;
import com.learningRepo.learningRepo.entity.User;
import com.learningRepo.learningRepo.repository.DataEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataEntryService {

    @Autowired
    private DataEntryRepository dataEntryRepository;
    @Autowired
    private UserService userService;


    public void saveDataEntry(DataEntityV2 data, String username){
        User user = userService.findUserByName(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username: " + username)
                );
        DataEntityV2 savedEntry = dataEntryRepository.save(data);

        user.getDataEntityV2List().add(savedEntry);
        userService.saveNewUser(user);
    }

    public void deleteDataEntry(ObjectId id, String username){
        User user = userService.findUserByName(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username: " + username)
                );

        boolean removed = user.getDataEntityV2List().removeIf(entry -> entry.getId().equals(id));
        if(removed){
            userService.saveNewUser(user);
            dataEntryRepository.deleteById(id);
        }
    }



    public List<DataEntityV2> getAllData(){
        return dataEntryRepository.findAll();
    }

}
