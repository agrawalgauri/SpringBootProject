package com.example.springbootproject.service;

import com.example.springbootproject.model.Post;
import com.example.springbootproject.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostServiceTest {
    @Mock
    PostRepository postRepository;
    @InjectMocks
    PostService postService;

    @Test
    void uniqueUsers_one_post() {
        Post post1 = Post.builder().id(10).userId(20).title("hello").build();
        when(postRepository.getPosts()).thenReturn(List.of(post1));
        assertEquals(1, postService.uniqueUsers());
    }

    @Test
    void uniqueUsers_null_post() {
        when(postRepository.getPosts()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> postService.uniqueUsers());
    }

    @Test
    void uniqueUsers_unique_post() {
        Post post1 = Post.builder().id(10).userId(20).title("hello").build();
        Post post2 = Post.builder().id(11).userId(21).title("hello").build();
        when(postRepository.getPosts()).thenReturn(List.of(post1, post2));
        assertEquals(2, postService.uniqueUsers());
    }

    @Test
    void uniqueUsers_duplicate_post() {
        Post post1 = Post.builder().id(10).userId(20).title("hello").build();
        Post post2 = Post.builder().id(11).userId(20).title("hello").build();
        when(postRepository.getPosts()).thenReturn(List.of(post1, post2));
        assertEquals(1, postService.uniqueUsers());
    }

    @Test
    void uniqueUsers_null_userid_post() {
        Post post1 = Post.builder().id(10).userId(null).title("hello").build();
        Post post2 = Post.builder().id(11).userId(20).title("hello").build();
        Post post3 = Post.builder().id(11).userId(21).title("hello").build();
        Post post4 = Post.builder().id(10).userId(null).title("hello").build();
        when(postRepository.getPosts()).thenReturn(List.of(post1, post2, post3, post4));
        assertEquals(2, postService.uniqueUsers());
    }

    @Test
    void updatePost() {
    }

    @Test
    void getPosts() {
    }
}