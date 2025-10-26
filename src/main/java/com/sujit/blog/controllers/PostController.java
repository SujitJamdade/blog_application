package com.sujit.blog.controllers;

import com.sujit.blog.entities.Post;
import com.sujit.blog.payloads.ApiResponse;
import com.sujit.blog.payloads.PostDTO;
import com.sujit.blog.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    // create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(
            @Valid @RequestBody PostDTO postDTO,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId){

        PostDTO createdPost = postService.createPost(postDTO,userId, categoryId);
        return new ResponseEntity<PostDTO>(createdPost, HttpStatus.CREATED);

    }

    // get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Integer userId){

        List<PostDTO> posts = postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
    }

    // get by category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUCategory(@PathVariable Integer categoryId){

        List<PostDTO> posts = postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
    }

    // get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPost(){
        List<PostDTO> allPost = postService.getAllPost();
        return new ResponseEntity<>(allPost, HttpStatus.OK);
    }

    // get post by postId
    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId){
        PostDTO postDTO = postService.getPostById(postId);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

    // update post
    @PutMapping("/update/{postId}")
    public ResponseEntity<PostDTO> updatePost(
            @Valid @RequestBody PostDTO postDTO,
            @PathVariable Integer postId){

        PostDTO updatedPost = postService.updatePost(postDTO, postId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ApiResponse("Post is successfully deleted !!", true);
    }

}


