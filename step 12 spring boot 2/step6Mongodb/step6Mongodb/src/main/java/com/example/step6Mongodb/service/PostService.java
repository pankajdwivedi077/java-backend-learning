package com.example.step6Mongodb.service;

import com.example.step6Mongodb.model.Post;
import com.example.step6Mongodb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Post add(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findBySearch(String text) {
        return postRepository.findByText(text);
    }
}
