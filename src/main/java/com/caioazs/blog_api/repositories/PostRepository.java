package com.caioazs.blog_api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.caioazs.blog_api.models.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	List<Post> findByTitleContainingIgnoreCase(String text);
}
