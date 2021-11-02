package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String showIndex() {
        return "My index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showSingleIndex(@PathVariable int id) {
        return "Showing index: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createIndex() {
        return "Create posts";
    }

    @PostMapping ("/posts/create")
    @ResponseBody
    public String createAds() {
        return "Create Ads";
    }


}
