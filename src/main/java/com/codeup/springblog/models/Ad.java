package com.codeup.springblog.models;


import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = true, length = 300)
    private String title;
    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;



}
