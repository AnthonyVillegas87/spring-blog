package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Coffee;
import com.codeup.springblog.repositories.CoffeeRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoffeeController {

    private final CoffeeRepository coffeeRepository;
    private final EmailService emailService;

    public CoffeeController(CoffeeRepository coffeeRepository, EmailService emailService) {

        this.coffeeRepository = coffeeRepository;
        this.emailService = emailService;
    }



    @GetMapping("/coffee")
    public String coffeeInfo() {
        return "views-lecture/coffee";
    }

    @GetMapping("/coffee/{roast}")
    public String roastSelection(@PathVariable String roast, Model model) {

        model.addAttribute("selections", coffeeRepository.findByRoast(roast));

//        Coffee selection = new Coffee(roast, "Cool Beans");
//        Coffee selection2 = new Coffee(roast, "Java Beans");
//        selection.setRoast(roast);
//        if (roast.equals("dark")) {
//            selection.setOrigin("Columbia");
//            selection2.setOrigin("Brazil");
//        } else if (roast.equals("medium")) {
//            selection.setOrigin("New Guinea");
//            selection2.setOrigin("Sumatra");
//        } else {
//            selection.setOrigin("Kenya");
//            selection2.setOrigin("Ethiopia");
//        }
////        model.addAttribute("roast", roast);
////        boolean darkChoice = false;
////        if(roast.equals("dark")) {
////            darkChoice = true;
////        }
//        List<Coffee> selections = new ArrayList<>();
//        selections.add(selection);
//        selections.add(selection2);
//        model.addAttribute("roast", roast);
//        model.addAttribute("selections", selections);

        return "views-lecture/coffee";
    }


    @GetMapping("/coffee/createCoffee")
    public String showCoffeeForm(Model model) {
        model.addAttribute("coffee", new Coffee());
        return "/coffees/createCoffee";
    }

    @PostMapping("/coffee/createCoffee")
    public String createCoffee(@ModelAttribute Coffee coffee) {
        coffeeRepository.save(coffee);
        return "redirect:/coffee";
    }

    @PostMapping("/coffee")
    public String newsletterSignup(@RequestParam(name="email") String email, Model model){
        model.addAttribute("email", email);

        emailService.prepareAndSend(email, "You have signed up for coffee emails! Thank you!");
        return "views-lecture/coffee";
    }


}
