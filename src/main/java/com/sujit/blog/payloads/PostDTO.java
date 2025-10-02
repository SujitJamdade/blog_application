package com.sujit.blog.payloads;

import jakarta.persistence.Column;

import java.util.Date;

public class PostDTO {

    private String title;
    private String content;

    // Constructor

    public PostDTO() {
    }

    public PostDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter & Setter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
