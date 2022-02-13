package com.example.springbootproject.service;

import com.example.springbootproject.model.Post;
import com.example.springbootproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Post> updatePost(Post post) {
        postRepository.updatePost(post);
        return postRepository.getPosts();
    }

    public List<Post> getPosts(boolean sort) {
        if (sort) {
            return postRepository.getPosts().stream()
                    .sorted((x, y) -> x.getTitle().compareTo(y.getTitle()))
                    .collect(Collectors.toList());
        }
        return postRepository.getPosts();
    }
}
