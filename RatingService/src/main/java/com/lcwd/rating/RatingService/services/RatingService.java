package com.lcwd.rating.RatingService.services;

import java.util.List;

import com.lcwd.rating.RatingService.entities.Rating;

public interface RatingService {
    //create
	Rating CreatRating(Rating rating);
	
	//get all ratings
	List<Rating> getAllRatings();
	
	//get all by userId
	List<Rating> getRatingByUserId(String userId);
	
	//get all by hotelId
	List<Rating> getRatingByHotelId(String hotelId);
}
