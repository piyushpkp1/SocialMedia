package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long postId); // Method to retrieve a post by its ID
    List<Post> findAllByOrderByDateDesc(); // Method to retrieve all posts sorted by date in descending order
}
