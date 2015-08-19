package com.example.myproject.dao;

import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myproject.bean.Product;

@PropertySource("application.properties")
public interface ProductRepository extends JpaRepository<Product, Integer> {

}