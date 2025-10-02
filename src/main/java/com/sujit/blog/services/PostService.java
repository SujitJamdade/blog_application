package com.sujit.blog.services;

import com.sujit.blog.entities.Post;
import com.sujit.blog.payloads.PostDTO;

import java.util.List;

public interface PostService {

    // create
    Post createPost(PostDTO postDTO, Integer userId, Integer categoryId);

    // update
    Post updatePost(PostDTO postDTO, Integer postId);

    // delete
    void deletePost(Integer postId);

    // get all posts
    List<Post> getAllPost();

    // get single post
    Post getPostById(Integer postId);

    // get all post by user
    List<Post> getPostByUser(Integer postId);

    // get all posts by category
    List<Post> getPostByCategory(Integer categoryId);

    // search post by keyword
    List<Post> searchPosts(String keyword);





}
