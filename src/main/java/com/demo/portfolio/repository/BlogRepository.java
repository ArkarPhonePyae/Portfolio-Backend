package com.demo.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.portfolio.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}