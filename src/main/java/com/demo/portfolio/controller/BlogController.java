package com.demo.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.portfolio.entity.Blog;
import com.demo.portfolio.service.BlogService;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "*") 
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
    }
    
    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }
}