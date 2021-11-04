package com.codeup.springblog.models;




import com.mysql.cj.protocol.ColumnDefinition;

import javax.persistence.*;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition =  "int(11) unsigned NOT NULL")
    private long id;
    @Column(columnDefinition = "tinyint(3) NOT NULL", unique = true, nullable = false)
    private int age;
    @Column(columnDefinition = "varchar(200) NOT NULL", nullable = false)
    private String name;
    @Column(columnDefinition = "char(2) DEFAULT 'XX'")
    private String resideState;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }




}
