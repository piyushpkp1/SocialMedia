package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface PostService {
    Post getPostById(Long postId);
    List<Post> getAllPosts();
    Post createPost(Post post);
    Post editPost(Long postId, Post updatedPost);
    void deletePost(Long postId);
    boolean userExists(Long userId);
    boolean postExists(Long postId);

    Post updatePost(Long postID, Post updatedPost) throws ChangeSetPersister.NotFoundException;
}
