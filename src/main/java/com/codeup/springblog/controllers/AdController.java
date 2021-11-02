package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/color/{color}")
    @ResponseBody
    public String returnColor(@PathVariable String color) {
        return "<h1 style='color:" + color + "'>" + color + "</h1>";
    }

    @GetMapping("/bg/{color1}/font/{color2}")
    @ResponseBody
    public String returnBgFontColor(@PathVariable String color1, @PathVariable String color2) {
        return String.format("<h1>style='background-color: %s;color:%s'>THIS IS THE FONT</h1>", color1,color2);
    }

    @GetMapping("/name")
    @ResponseBody
    public String returnName(@RequestParam String n) {
        return "Returning Name: " + n;
    }


}
