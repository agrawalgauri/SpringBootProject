package com.example.springbootproject.service;

import com.example.springbootproject.model.Post;
import com.example.springbootproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository springRepository;
    @Autowired
    public PostService(PostRepository springRepository) {
        this.springRepository=springRepository;
    }

    public List<Post> uniqueUsers() {
        return springRepository.uniqueUsers();
    }
}
