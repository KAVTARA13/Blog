package com.example.blogapplication.services;

import com.example.blogapplication.api.GPT;
import com.example.blogapplication.models.Post;
import com.example.blogapplication.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll(){
        GPT.getBlog("money");
        return postRepository.findAll();
    }
}
