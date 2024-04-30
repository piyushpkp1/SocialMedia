package com.example.demo.model;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postID;

    private String postBody;
    private Date date;
    private Long userID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    // Constructors
    public Post() {
        // Default constructor
    }

    public Post(String postBody, Date date, User user) {
        this.postBody = postBody;
        this.date = date;
        this.user = user;
    }



    public Post( String postBody, Long userID) {
        this.postBody = postBody;
        this.userID = userID;

    }

    // Getters and setters
    public Long getId() {
        return postID;
    }

    public void setId(Long id) {
        this.postID = this.postID++;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getuserID() {
        return userID;
    }

    public Long getUserId() {
        if (userID != null) {
            return this.getuserID();
        } else {
            return null; // or throw an exception or handle the null case as needed
        }
    }
}
