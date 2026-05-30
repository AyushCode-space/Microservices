package com.lcwd.rating.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
   
	@Autowired
	private RatingService ratingService;
	
	//create rating
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating createdRating = ratingService.CreatRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable(value = "userId") String userId){
		List<Rating> ratings = ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/hotels/{HotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable(value = "HotelId") String HotelId){
		List<Rating> ratings = ratingService.getRatingByHotelId(HotelId);
        return ResponseEntity.ok(ratings);
	}
	
	
}
