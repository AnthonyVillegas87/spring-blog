package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RollDiceController {

    @GetMapping("/dice-roll")
    public String diceInfo() {
        return "partials/dice-roll";
    }


    @GetMapping("/dice-roll/{n}")
    public  String rollDice(@PathVariable int n, Model model) {
        model.addAttribute("n", n);

        boolean correctChoice = false;
        int i = (int)(6 * Math.random() + 1);
        model.addAttribute("i", i);
        if(n == i) {
            correctChoice = true;
        }


        model.addAttribute("correctChoice", correctChoice);
        return "partials/dice-roll";
   }



}
