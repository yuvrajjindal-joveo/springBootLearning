package com.learningRepo.learningRepo.repository;

import com.learningRepo.learningRepo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String > {

    Optional<User> findByuserName(String username);
}
