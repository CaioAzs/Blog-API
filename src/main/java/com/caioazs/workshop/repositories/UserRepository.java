package com.caioazs.workshop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.caioazs.workshop.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{
    
}
