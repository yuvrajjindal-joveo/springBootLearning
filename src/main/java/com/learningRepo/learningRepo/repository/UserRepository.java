package com.learningRepo.learningRepo.repository;

import com.learningRepo.learningRepo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String > {
    User findByuserName(String username);
}
