package com.example.springbootproject.repository;

import com.example.springbootproject.model.Post;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

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

}
