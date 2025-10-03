package com.sujit.blog.payloads;

import com.sujit.blog.entities.Category;
import com.sujit.blog.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    private CategoryDto category;
    private UserDTO user;

}
