package com.example.step6Mongodb.controller;

import com.example.step6Mongodb.model.Post;
import com.example.step6Mongodb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping()
    public List<Post> getAllPost(){
       return postService.getAllPost();
    }

    @PostMapping()
    public Post addPost(@RequestBody Post post){
        return postService.add(post);
    }

    @GetMapping("/{text}")
    public List<Post> search(@PathVariable String text){
        return postService.findBySearch(text);
    }

}
