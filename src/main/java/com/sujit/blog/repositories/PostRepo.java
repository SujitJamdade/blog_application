package com.sujit.blog.repositories;

import com.sujit.blog.entities.Category;
import com.sujit.blog.entities.Post;
import com.sujit.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String keyword);
}
