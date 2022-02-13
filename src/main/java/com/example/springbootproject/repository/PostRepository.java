package com.example.springbootproject.repository;

import com.example.springbootproject.model.Post;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepository {

    private final Gson gson;

    @Autowired
    public PostRepository(Gson gson) {
        this.gson = gson;
        uniqueUsers();
    }

    public List<Post> uniqueUsers() {
        try {
            List<Post> posts = Arrays.asList(gson.fromJson(Files.newBufferedReader(Paths.get("src", "main", "resources", "datasource", "data-source.json")), Post[].class));
            posts.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
