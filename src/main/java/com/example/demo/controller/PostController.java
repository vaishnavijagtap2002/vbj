package com.example.demo.controller;

import com.example.demo.Payload.PostDto;
import com.example.demo.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto){

        PostDto post = postService.createPost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String>deletePost(
            @RequestParam long id
    ){
        postService.deletePost(id);
        return new ResponseEntity<>("Post is Deleted",HttpStatus.OK);
    }

}
