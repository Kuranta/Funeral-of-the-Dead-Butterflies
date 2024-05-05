package com.microservices.poemsservice.repository;

import com.microservices.poemsservice.model.Poetry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoetryRepository extends MongoRepository<Poetry, String> {
}
