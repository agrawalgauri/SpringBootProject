package com.example.springbootproject.repository;

import com.example.springbootproject.model.Post;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class PostRepository {

    private final Gson gson;
    private List<Post> postList;

    @Autowired
    public PostRepository(Gson gson) {
        this.gson = gson;
        loadPosts();
    }

    public List<Post> getPosts() {
        return postList;
    }

    private void loadPosts() {
        try {
            postList = Arrays.asList(gson.fromJson(Files.newBufferedReader(Paths.get("src", "main", "resources", "datasource", "data-source.json")), Post[].class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Post updatePost(Post post) {
        Post dbPost = postList.stream()
                .filter((x) -> Objects.equals(x.getId(), post.getId()))
                .findFirst()
                .orElse(null);
        if (dbPost == null) {
            throw new NullPointerException("No Post exists with id="+post.getId());
        }
        if (post.getBody() != null) {
            dbPost.setBody(post.getBody());
        }
        if (post.getTitle() != null) {
            dbPost.setTitle(post.getTitle());
        }
        return dbPost;
    }
}
