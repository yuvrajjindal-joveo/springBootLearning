package com.learningRepo.learningRepo.services;

import com.learningRepo.learningRepo.entity.User;
import com.learningRepo.learningRepo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public void saveUser(User userData){
        userRepository.save(userData);
    }

    public User findUserByName(String userName){
        return userRepository.findByuserName(userName);
    }

    public boolean verifyUser(String userName, String password){
        User user = findUserByName(userName);

        if(user != null){
            if(user.equals(password)){
                return true;
            }
        }

        return false;
    }
}
