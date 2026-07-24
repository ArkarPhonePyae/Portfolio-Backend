package com.demo.portfolio.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.portfolio.entity.Blog;
import com.demo.portfolio.repository.BlogRepository;
import com.demo.portfolio.service.BlogService;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll(); 
    }

    @Override
    public Optional<Blog> getBlogById(Long id) {
        return blogRepository.findById(id);
    }
    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }
}