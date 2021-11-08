package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.AdRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {

    private final AdRepository adRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;


    public AdController(AdRepository adRepository, EmailService emailService, UserRepository userRepository) {
        this.adRepository = adRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;

    }

    @GetMapping("/ads")
    public String showAds(Model model) {
         model.addAttribute("ads", adRepository.findAll());
        return "ads/index";
    }
    @GetMapping("/ads/{id}")
    @ResponseBody
    public Ad showSingleAd(@PathVariable long id) {
        return adRepository.getById(id).get();
    }

    @PostMapping ("/ads")
    @ResponseBody
    public String createAds(@RequestBody Ad newAd) {
        adRepository.save(newAd);
        return String.format("Create Ads %s :" , newAd.getId());
    }
    @GetMapping("/ads/{title}")
    @ResponseBody
    public Ad getByTitle(@PathVariable String title) {
        return adRepository.findByTitle(title);
    }
//@GetMapping("/ads/{titlePart}")
//@ResponseBody
//public List<Ad> getByTitle(@PathVariable String titlePart) {
//        return getByTitleLike(titlePart);
//}

    @GetMapping("/ads/create")
    public String showCreateAdsForm(Model model){
        model.addAttribute("ad", new Ad());
        return "ads/create";
    }
    @PostMapping("/ads/create")
    public String createAdWithForm(@ModelAttribute Ad ad){
        User user = userRepository.getById(1L);
        ad.setOwner(user);
        adRepository.save(ad);
        emailService.prepareAndSend(ad, "You created " + ad.getTitle(), ad.getDescription());
        return "redirect:/ads";
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
