package com.example.springbootproject.controller;

import com.example.springbootproject.model.Post;
import com.example.springbootproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/springBoot")
public class PostController {

    private PostService springService;

    @Autowired
    public PostController(PostService springService) {
        this.springService = springService;
    }

    @GetMapping
    public List<Post> uniqueUsers() {
        return springService.uniqueUsers();
    }
}
