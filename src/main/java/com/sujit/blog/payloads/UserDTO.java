package com.sujit.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;

    @NotEmpty
    @Size(min=4, message = "Username must be min of 4 Character !!")
    private String name;

    @Email(message = "Email address is not valid !!")
    private String email;

    @NotEmpty(message = "Password is mandatory filed !!")
    @Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars !!")
    private String password;

    @NotEmpty
    private String about;

}