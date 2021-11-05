package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostImage;
import com.codeup.springblog.repositories.PostRepository;
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

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // ADD endpoint to send the user an edit posts form/view
    //create an edit post form
    //create another endpoint to handle the post request of editing a post


///============== Show VIEW
        @GetMapping("/posts")
    public String showIndex(Model viewModel) {
        //seed posts in DB
        //fetch all posts with post repository
            List<Post> posts = postRepository.findAll();
//            Post blog1 = new Post("Day One", "Today we learned how to pass data to views");
//            Post blog2 = new Post("Day Two", "Today we learned how to create partials and include them in various pages");
//        blogs.add(blog1);
//        blogs.add(blog2);
       viewModel.addAttribute("posts", posts);
       return "posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String show(@PathVariable long id) {

        return "Posts " + id;
    }



//===================Edit View
    @GetMapping("/posts/{id}/edit")
    public String showEditIndex(@PathVariable long id, Model viewModel) {
        //Edit form send
        viewModel.addAttribute("post", postRepository.getById(id));
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @RequestParam(name="title") String title, @RequestParam String body) {
    //Use the new form inputs to update the existing post in DB
    // Pull existing post from DB
    Post post = postRepository.getById(id);
    post.setTitle(title);
    post.setBody(body);
    //set the title & body to param values
    // set the change inthe DB with postRepository
    postRepository.save(post);

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
    public String create() {

        return "posts/create";
    }

    @PostMapping ("/posts/create")
    public String insert(@RequestParam String title, @RequestParam String body, @RequestParam List<String> urls) {
        List<PostImage> image = new ArrayList<>();

        Post post = new Post(title, body);
        for(String url : urls) {
            PostImage postImage = new PostImage(url);
            postImage.setPost(post);
            image.add(postImage);
        }
        post.setImages(image);


        postRepository.save(post);
        return "redirect:/posts";
    }




}
