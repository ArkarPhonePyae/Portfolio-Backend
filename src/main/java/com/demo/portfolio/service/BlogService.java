package com.demo.portfolio.service;

import java.util.List;
import java.util.Optional;
import com.demo.portfolio.entity.Blog;

public interface BlogService {
    List<Blog> getAllBlogs();
    Optional<Blog> getBlogById(Long id);
    Blog createBlog(Blog blog);
}