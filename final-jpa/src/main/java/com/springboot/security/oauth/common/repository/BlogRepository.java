package com.springboot.security.oauth.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.security.oauth.common.entity.Blog;


public interface BlogRepository extends JpaRepository<Blog, Long>{

}
