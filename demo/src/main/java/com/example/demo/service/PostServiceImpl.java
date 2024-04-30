package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Post getPostById(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        return postOptional.orElse(null);
    }

    @Override
    public boolean userExists(Long userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByDateDesc();
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post editPost(Long postId, Post updatedPost) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            updatedPost.setId(postId); // Ensure the ID is set correctly
            return postRepository.save(updatedPost);
        } else {
            return null; // Post with the given ID not found
        }
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public boolean postExists(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        return postOptional.isPresent();
    }


    public Post updatePost(Long postID, Post updatedPost) {
        Optional<Post> postOptional = postRepository.findById(postID);
        postOptional.ifPresent(existingPost -> {
            existingPost.setPostBody(updatedPost.getPostBody());
            // Update other fields as needed
            postRepository.save(existingPost);
        });
        return postOptional.orElse(null);

    }
}
