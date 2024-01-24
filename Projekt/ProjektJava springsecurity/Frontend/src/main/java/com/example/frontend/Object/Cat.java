package com.example.frontend.Object;
public class Cat{
    private Long id;
    private String content;
    private String photoURL;

    public Cat(String content, String photoURL) {
        this.content = content;
        this.photoURL = photoURL;
    }

    public Cat() {}

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

