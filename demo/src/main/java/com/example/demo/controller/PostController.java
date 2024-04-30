package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        if (postService.userExists(post.getUserId())) {
            postService.createPost(post);
            return ResponseEntity.ok("Post created successfully");
        }
        else{
            return ResponseEntity.ok("User does not exist");
        }
    }

    @GetMapping("/post")
    public Post getPostDetails(@RequestParam Long postID) {
        return postService.getPostById(postID);
    }

    @PatchMapping("/post")
    public ResponseEntity<String> updatePost(@RequestParam Long postID, @RequestBody Post updatedPost) {
        try {
            Post updated = postService.updatePost(postID, updatedPost);
            if (updated != null) {
                return ResponseEntity.ok("Post updated successfully");
            } else {
                return ResponseEntity.ok("Post does not exist");
            }
        } catch (ChangeSetPersister.NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
        }
    }

    @DeleteMapping("/post")
    public ResponseEntity<String> deletePost(@RequestParam Long postId) {

        postService.deletePost(postId);
        return ResponseEntity.ok("Post deleted successfully");
    }
}
