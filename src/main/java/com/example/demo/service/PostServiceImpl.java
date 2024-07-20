
package com.example.demo.service;

import com.example.demo.Payload.PostDto;
import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);

        Post savedEntity = postRepository.save(post);
        PostDto dto = mapToDto(savedEntity);
        return dto;
    }

    @Override
    public PostDto deletePost(long id) {
        postRepository.findById(id);
        return null;
    }

    Post mapToEntity(PostDto dto){
        Post entity=new Post();
        entity.setId(dto.getId());
        entity.setDiscription(dto.getDiscription());
        entity.setTitle(dto.getTitle());
        return entity;
    }

    PostDto mapToDto(Post post){
        PostDto dto=new PostDto();
        dto.setId(post.getId());
        dto.setDiscription(post.getDiscription());
        dto.setTitle(post.getTitle());
        return dto;
    }
}
