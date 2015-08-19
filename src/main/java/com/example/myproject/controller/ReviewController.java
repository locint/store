package com.example.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.bean.Review;
import com.example.myproject.dao.ReviewRepository;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	 @Autowired
	  private ReviewRepository repo;
	 
	  @RequestMapping(method = RequestMethod.GET)
	  public List findReviews() {
		  
		  return repo.findAll();
	  }
	  
	  @RequestMapping(method = RequestMethod.POST)
	  public Review addReview(@RequestBody Review review) {
		 
		  review.setId(null);
		  return repo.saveAndFlush(review);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public Review updateReview(@RequestBody Review updatedReview, @PathVariable Integer id) {
		
	    updatedReview.setId(id);
	    return repo.saveAndFlush(updatedReview);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteReview(@PathVariable Integer id) {
		
	    repo.delete(id);
	  }

}
