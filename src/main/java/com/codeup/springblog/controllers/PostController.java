package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostImage;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
/// dependency injection
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    public PostController(PostRepository postRepository, UserRepository userRepository, EmailService emailService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    // ADD endpoint to send the user an edit posts form/view
    //create an edit post form
    //create another endpoint to handle the post request of editing a post


///============== Show VIEW
        @GetMapping("/posts")
    public String showIndex(Model viewModel) {
        //seed posts in DB
        //fetch all posts with post repository
//            List<Post> posts = ;
//            Post blog1 = new Post("Day One", "Today we learned how to pass data to views");
//            Post blog2 = new Post("Day Two", "Today we learned how to create partials and include them in various pages");
//        blogs.add(blog1);
//        blogs.add(blog2);
       viewModel.addAttribute("posts", postRepository.findAll());
       return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepository.getById(id));
        return "posts/show";
    }



//===================Edit View
    @GetMapping("/posts/{id}/edit")
    public String showEditIndex(@PathVariable long id, Model viewModel) {
        //Edit form send
        viewModel.addAttribute("post", postRepository.getById(id));
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String updatePost(@ModelAttribute Post post) {


    //Use the new form inputs to update the existing post in DB
    // Pull existing post from DB
    Post dBpost = postRepository.getById(post.getId());

    //set the title & body to param values
        dBpost.setTitle(post.getTitle());
        dBpost.setBody(post.getBody());
    // set the change inthe DB with postRepository
    postRepository.save(dBpost);

    return "redirect:/posts";

}


//==================DELETE VIEW
    @PostMapping ("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postRepository.deleteById(id);
        return "redirect:/posts";
    }





/// ====================== Create View
    @GetMapping("/posts/create")
    public String createForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping ("/posts/create")
    public String insert(@ModelAttribute Post post) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User author = userRepository.getById(principal.getId());
        post.setUser(author);
        postRepository.save(post);
        emailService.prepareAndSend(post, "You submitted: " + post.getTitle(), post.getBody());





//        List<PostImage> image = new ArrayList<>();
//
//        Post post = new Post(title, body);
//        for(String url : urls) {
//            PostImage postImage = new PostImage(url);
//            postImage.setPost(post);
//            image.add(postImage);
//        }
//        post.setImages(image);
//
//
//        postRepository.save(post);
        return "redirect:/posts";
    }




}
