package com.learningRepo.learningRepo.repository;
import com.learningRepo.learningRepo.entity.DataEntityV2;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface DataEntryRepository extends MongoRepository<DataEntityV2, ObjectId> {


}
