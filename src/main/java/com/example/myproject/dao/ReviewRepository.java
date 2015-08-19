package com.example.myproject.dao;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myproject.bean.Review;

@PropertySource("application.properties")
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
