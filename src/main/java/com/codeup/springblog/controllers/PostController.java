package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
/// dependency injection
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

        @GetMapping("/posts/index")
    public String showIndex() {
        //seed posts in DB
        //fetch all posts with post repository

//            Post blog1 = new Post("Day One", "Today we learned how to pass data to views");
//            Post blog2 = new Post("Day Two", "Today we learned how to create partials and include them in various pages");
//        List<Post> blogs = new ArrayList<>();
//        blogs.add(blog1);
//        blogs.add(blog2);
//
//        model.addAttribute("blogs", blogs);
//
       return "posts/index";
    }

    @PostMapping ("/posts/index")
    @ResponseBody
    public String createPost(@RequestBody Post newPost) {
        postRepository.save(newPost);
        return String.format("Create Ads %s :" , newPost.getId());
    }


// ADD endpoint to send the user an edit posts form/view

    //create an edit post form

    //create another endpoint to handle the post request of editing a post

//    @GetMapping("/posts/{id}")
//    public String showSingleIndex(@PathVariable int id, Model model) {
//        Post blog = new Post("My first post", "Create a new post & pass it to the view ");
//        model.addAttribute("blog", blog);
//        return "posts/show";
//    }



//    @GetMapping("/posts/create")
//    public String createIndex() {
//        return "Create posts";
//    }

//    @PostMapping ("/posts/create")
//    public String createAds() {
//        return "Create Ads";
//    }




}
