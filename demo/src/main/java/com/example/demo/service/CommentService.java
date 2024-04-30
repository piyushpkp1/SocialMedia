package com.example.demo.service;

import com.example.demo.model.Comment;

public interface CommentService {
    Comment createComment(Comment comment);
    Comment getCommentById(Long commentId);
    Comment editComment(Long commentId, Comment updatedComment);
    void deleteComment(Long commentId);
}
