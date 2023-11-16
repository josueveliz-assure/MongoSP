package com.mongospring.mongosp.repository;

import com.mongospring.mongosp.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
}
