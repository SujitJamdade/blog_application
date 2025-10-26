package com.sujit.blog.services;

import com.sujit.blog.entities.Post;
import com.sujit.blog.payloads.PostDTO;
import com.sujit.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {

    // create
    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);

    // update
    PostDTO updatePost(PostDTO postDTO, Integer postId);

    // delete
    void deletePost(Integer postId);

    // get all posts
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    // get single post
    PostDTO getPostById(Integer postId);

    // get all post by user
    List<PostDTO> getPostByUser(Integer userId);

    // get all posts by category
    List<PostDTO> getPostByCategory(Integer categoryId);

    // search post by keyword
    List<Post> searchPosts(String keyword);
}
