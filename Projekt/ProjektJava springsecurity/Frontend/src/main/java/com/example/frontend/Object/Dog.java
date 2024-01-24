package com.example.frontend.Object;

public class Dog {
    private Long id;
    private String content;
    private String photoURL;

    public Dog(String content, String photoURL) {
        this.content = content;
        this.photoURL = photoURL;
    }

    public Dog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}
