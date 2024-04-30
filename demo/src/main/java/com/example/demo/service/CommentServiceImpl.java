package com.example.demo.service;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        // Check if the post and user exist
        if (comment.getPost() == null || comment.getUser() == null) {
            // Relevant error returned if the post or user does not exist
            return null;
        }
        // Save the comment
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long commentId) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        return commentOptional.orElse(null); // Return null if comment not found
    }

    @Override
    public Comment editComment(Long commentId, Comment updatedComment) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isPresent()) {
            // Update the comment if it exists
            updatedComment.setId(commentId); // Ensure the ID is set correctly
            return commentRepository.save(updatedComment);
        } else {
            // Relevant error returned if the comment does not exist
            return null;
        }
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
