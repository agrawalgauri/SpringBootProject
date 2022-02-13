package com.example.springbootproject.service;

import com.example.springbootproject.model.Post;
import com.example.springbootproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Long uniqueUsers() {
        return postRepository.getPosts().stream()
                .map(Post::getUserId)
                .distinct()
                .count();
    }

}
