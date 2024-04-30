package com.example.demo.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentID;

    private String commentBody;
    private Date date;
    private Long userID;
    private Long postID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    // Constructors
    public Comment() {
        // Default constructor
    }

    public Comment(String commentBody, Date date, User user, Post post) {
        this.commentBody = commentBody;
        this.date = date;
        this.user = user;
        this.post = post;
    }

    public Comment(String commentBody, Long commentID){
        this.commentBody = commentBody;
        this.commentID = commentID;
    }

    public Comment(Long commentID){
        this.commentID = commentID;
    }

    // Getters and setters
    public Long getId() {
        return commentID;
    }

    public void setId(Long id) {
        this.commentID = id;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public Long getuserID(){
        return userID;
    }

    public void setUserID(Long UserID) {
        this.userID = UserID;
    }

    public void setPostID(Long PostID) {
        this.postID = PostID;
    }

    public Long getpostID(){
        return postID;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
