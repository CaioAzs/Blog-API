package com.caioazs.workshop.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.caioazs.workshop.models.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}