package com.example.demo.service;

import com.example.demo.Payload.CommentDto;
import com.example.demo.entity.Comment;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Long postId);
}
