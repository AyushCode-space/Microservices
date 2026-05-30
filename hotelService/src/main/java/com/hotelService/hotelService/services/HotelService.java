package com.hotelService.hotelService.services;

import java.util.List;

import com.hotelService.hotelService.entity.Hotel;

public interface HotelService {
     
	 Hotel createHotel(Hotel hotel);
	
     List<Hotel> getAllHotels();
     
     Hotel getHotelById(String id);
     
     
}
