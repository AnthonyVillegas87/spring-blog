package com.codeup.springblog.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 300)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String  body;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Post() {}


    public Post(String title, String body) {
        this.title = title;
        this.body = body;

    }

    public Post(String title, String body, List<PostImage> images) {
        this.title = title;
        this.body = body;
        this.images = images;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    @Override
//    public String toString() {
//        return "Post{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", body='" + body + '\'' +
//                ", images=" + images +
//                ", user=" + user +
//                '}';
//    }

}
