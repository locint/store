package com.example.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.bean.Product;
import com.example.myproject.dao.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductRepository repo;
  
  @RequestMapping(method = RequestMethod.GET)
  public List findProducts() {
	  System.out.println(repo.findAll());
	  return repo.findAll();
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Product addProduct(@RequestBody Product product) {
	  product.setId(null);
	  return repo.saveAndFlush(product);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Product updateProduct(@RequestBody Product updatedProduct, @PathVariable Integer id) {
    updatedProduct.setId(id);
    return repo.saveAndFlush(updatedProduct);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteProduct(@PathVariable Integer id) {
    repo.delete(id);
  }
}
