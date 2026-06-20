package com.lcwd.rating.RatingService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.rating.RatingService.entities.Hotel;
import com.lcwd.rating.RatingService.entities.Rating;
import com.lcwd.rating.RatingService.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
    
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Rating CreatRating(Rating rating) {
		String id = UUID.randomUUID().toString();
		rating.setRatingId(id);
		return ratingRepository.save(rating) ;
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		List<Rating> ratings = ratingRepository.findByUserId(userId);
		for(Rating rating : ratings) {
		Hotel hotel = restTemplate.getForObject("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
		rating.setHotel(hotel);
		}
		return ratings;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
