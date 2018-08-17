package com.sravs.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sravs.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
