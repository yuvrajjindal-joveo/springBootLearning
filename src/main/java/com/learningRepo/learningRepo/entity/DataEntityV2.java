package com.learningRepo.learningRepo.entity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "general_data")
@Getter
@Setter
public class DataEntityV2 {
    @Id
    private ObjectId id;

    private String message;
    private String type;

//    public String getId() { return id; }
//    public void setId(String id) { this.id = id; }
//
//    public String getMessage() { return message; }
//    public void setMessage(String message) { this.message = message; }
//
//    public String getType() { return type; }
//    public void setType(String type) { this.type = type; }
}
