package com.sujit.blog.payloads;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Integer postId;

    @NotEmpty(message = "Title is mandatory")
    private String title;

    @NotEmpty(message = "Content is mandatory")
    private String content;
    private String imageName;
    private Date addedDate;

    private CategoryDto category;
    private UserDTO user;

}
