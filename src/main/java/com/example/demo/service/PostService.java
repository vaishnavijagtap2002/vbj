package com.example.demo.service;

import com.example.demo.Payload.CommentDto;
import com.example.demo.Payload.PostDto;
import com.example.demo.entity.Comment;

public interface PostService {
    public PostDto createPost(PostDto postDto);


    PostDto deletePost(long id);
}
