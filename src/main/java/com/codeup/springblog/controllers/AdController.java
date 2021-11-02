package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdController {
    @GetMapping("/ads")
    @ResponseBody
    public String showAds() {
        return "Ads at a glance";
    }

    @GetMapping("/ads/{id}")
        @ResponseBody
        public String showSingleAd(@PathVariable int id) {
            return "Showing ad: " + id;
        }

    @PostMapping ("/ads")
    @ResponseBody
    public String createAds() {
        return "Create Ads";
    }


}
