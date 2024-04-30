package com.example.demo.repository;

import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId); // Method to retrieve comments by post ID
    List<Comment> findByUserId(Long userId); // Method to retrieve comments by user ID
    void deleteByPostId(Long postId); // Method to delete comments by post ID
    void deleteByUserId(Long userId); // Method to delete comments by user ID
}
