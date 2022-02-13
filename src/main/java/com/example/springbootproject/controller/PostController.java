package com.example.springbootproject.controller;

import com.example.springbootproject.model.Post;
import com.example.springbootproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/users/unique")
    public Long uniqueUsers() {
        return postService.uniqueUsers();
    }

    @GetMapping
    public List<Post> getPosts(@RequestParam(required = false,defaultValue = "true") boolean sort){
        return postService.getPosts(sort);
    }

    @PatchMapping("/{id}")
    public List<Post> updatePost(@PathVariable Integer id, @RequestBody Post post){
        post.setId(id);
        return postService.updatePost(post);
    }
}
