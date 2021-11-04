package com.codeup.springblog.models;


import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = true, length = 300)
    private String title;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String  body;


    public Post() {}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;

    }



    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
