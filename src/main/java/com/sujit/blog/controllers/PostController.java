package com.sujit.blog.controllers;

import com.sujit.blog.entities.Post;
import com.sujit.blog.payloads.PostDTO;
import com.sujit.blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    // create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(
            @RequestBody PostDTO postDTO,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId){

        PostDTO createdPost = postService.createPost(postDTO,userId, categoryId);
        return new ResponseEntity<PostDTO>(createdPost, HttpStatus.CREATED);

    }


}


