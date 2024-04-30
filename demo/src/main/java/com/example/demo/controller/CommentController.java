package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @PostMapping("/comment")
    public ResponseEntity<String> createComment(@RequestBody Comment comment) {
        String commentBody = comment.getCommentBody();
        Long postId = comment.getpostID();
        Long userId = comment.getuserID();

        // Check if the user exists
        if (!userService.userExists(userId)) {
            return ResponseEntity.badRequest().body("User does not exist");
        }

        // Check if the post exists
        if (!postService.postExists(postId)) {
            return ResponseEntity.badRequest().body("Post does not exist");
        }

        // Create the comment
        Comment commentt = new Comment();
        commentt.setCommentBody(commentBody);
        commentt.setPost(postService.getPostById(postId));
        commentt.setUser(userService.getUserById(userId));
        commentService.createComment(commentt);

        return ResponseEntity.ok("Comment created successfully");
    }

    @GetMapping("/comment")
    public Comment getCommentById(@RequestParam Long commentID) {
        return commentService.getCommentById(commentID);
    }



    @PatchMapping("/comment")
    public ResponseEntity<String> editComment(@RequestParam Long commentId, @RequestBody Comment updatedComment) {
        Comment editedComment = commentService.editComment(commentId, updatedComment);
        if (editedComment != null) {
            return ResponseEntity.ok("Comment edited successfully");
        } else {
            return ResponseEntity.ok("Comment does not exist");
        }
    }


    @DeleteMapping("/comment")
    public ResponseEntity<String> deleteComment(@RequestParam Long commentId) {

        commentService.deleteComment(commentId);
        return ResponseEntity.ok("Comment deleted successfully");
    }
}
