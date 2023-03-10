package com.caioazs.blog_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caioazs.blog_api.exceptions.ObjectNotFoundException;
import com.caioazs.blog_api.models.Post;
import com.caioazs.blog_api.repositories.PostRepository;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String title){
        return postRepository.findByTitleContainingIgnoreCase(title);
    }

}
