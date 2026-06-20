package com.lcwd.rating.RatingService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "micro_rating")
public class Rating {
	   @Id
	   private String ratingId;
	   
	   private String userId;
	   private String hotelId;
	   private int rating;
	   private String feedback;
	   
	   @Transient
	   private Hotel hotel;
	
	   
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public String getRatingId() {
		return ratingId;
	}
	public String getUserId() {
		return userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public int getRating() {
		return rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	   
}
