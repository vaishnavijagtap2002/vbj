package com.example.demo.service;

import com.example.demo.Payload.CommentDto;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostService postService, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }
    @Override
    public CommentDto createComment(CommentDto commentDto, Long postId) {
        Post post = postRepository.findById(postId).get();
        commentDto.setPost(post);
        Comment comment = mapToEntity(commentDto);
        Comment savedComment = commentRepository.save(comment);
        CommentDto dtos = maoToDto(savedComment);
        return dtos;
    }
     Comment mapToEntity(CommentDto dto){
        Comment entity=new Comment();
        entity.setPost(dto.getPost());
        entity.setEmail(dto.getEmail());
        entity.setContent(dto.getContent());
        return entity;
    }
    CommentDto maoToDto(Comment comment){
        CommentDto dto=new CommentDto();
        dto.setPost(comment.getPost());
        dto.setId(comment.getId());
        dto.setEmail(comment.getEmail());
        dto.setContent(comment.getContent());
        return dto;
    }
}
