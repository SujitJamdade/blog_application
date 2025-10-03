package com.sujit.blog.service.impl;

import com.sujit.blog.entities.Category;
import com.sujit.blog.entities.Post;
import com.sujit.blog.entities.User;
import com.sujit.blog.exceptions.ResourceNotFoundException;
import com.sujit.blog.payloads.PostDTO;
import com.sujit.blog.repositories.CategoryRepo;
import com.sujit.blog.repositories.PostRepo;
import com.sujit.blog.repositories.UserRepo;
import com.sujit.blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    private final CategoryRepo categoryRepo;

    // create
    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId){

        // Get User
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));

        // Get Category
        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        Post post = modelMapper.map(postDTO, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post savedPost = postRepo.save(post);

        return modelMapper.map(savedPost, PostDTO.class);
    }

    // update
    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId){
        return null;
    }

    // delete
    @Override
    public void deletePost(Integer postId){

    }

    // get all posts
    @Override
    public List<Post> getAllPost(){
        return null;
    }

    // get single post
    @Override
    public Post getPostById(Integer postId){
        return null;
    }


    // get all posts by category
    @Override
    public List<PostDTO> getPostByCategory(Integer categoryId){

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        List<Post> posts = postRepo.findByCategory(category);

        return posts.stream()
                .map((post) -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
    }

    // get all post by user
    @Override
    public List<PostDTO> getPostByUser(Integer userId){

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

        List<Post> posts = postRepo.findByUser(user);

        return posts.stream()
                .map((post) -> modelMapper.map(post, PostDTO.class)).toList();
    }

    // search post by keyword
    @Override
    public List<Post> searchPosts(String keyword){
        return null;
    }

}
