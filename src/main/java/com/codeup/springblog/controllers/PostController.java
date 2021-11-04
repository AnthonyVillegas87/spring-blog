package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String showIndex(Model model) {
            Post blog1 = new Post("Day One", "Today we learned how to pass data to views");
            Post blog2 = new Post("Day Two", "Today we learned how to create partials and include them in various pages");
        List<Post> blogs = new ArrayList<>();
        blogs.add(blog1);
        blogs.add(blog2);

        model.addAttribute("blogs", blogs);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showSingleIndex(@PathVariable int id, Model model) {
        Post blog = new Post("My first post", "Create a new post & pass it to the view ");
        model.addAttribute("blog", blog);
        return "posts/show";
    }



    @GetMapping("/posts/create")
    public String createIndex() {
        return "Create posts";
    }

    @PostMapping ("/posts/create")
    public String createAds() {
        return "Create Ads";
    }


}
