package com.example.apidownloader.object;

import jakarta.persistence.*;

@Entity
@Table(name="Joke")
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="content")
    private String content;
    @Column(name="photoURL")
    private String photoURL;

    public Joke(String content, String photoURL) {
        this.content = content;
        this.photoURL = photoURL;
    }

    public Joke() {
    }

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
