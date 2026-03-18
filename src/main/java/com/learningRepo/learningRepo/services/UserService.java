package com.learningRepo.learningRepo.services;

import com.learningRepo.learningRepo.entity.DataEntityV2;
import com.learningRepo.learningRepo.entity.User;
import com.learningRepo.learningRepo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public User saveNewUser(User userData){
        return userRepository.save(userData);
    }

    public Optional<User> findUserByName(String userName){
        return userRepository.findByuserName(userName);
    }

    public void addUsersDataEntry(String username, DataEntityV2 data){

    }


}
