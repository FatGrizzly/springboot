package com.example.reactdemo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repo extends MongoRepository<Student,String> {
}
