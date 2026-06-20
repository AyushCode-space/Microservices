package com.userService.UserService.services;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userService.UserService.entities.Rating;
import com.userService.UserService.entities.User;
import com.userService.UserService.exception.ResourceNotFoundException;
import com.userService.UserService.repositories.UserRepositories;

@Service
public class ServiceImpl implements UserService{
    
	@Autowired
	private UserRepositories userRepositories;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger log = LoggerFactory.getLogger(ServiceImpl.class);
	
	@Override
	public User createUser(User user) {
		String id = UUID.randomUUID().toString();
           user.setUserId(id);
		return userRepositories.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> user= userRepositories.findAll() ;
		for(User u : user) {
		 List<Rating>rating =	restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+u.getUserId(),List.class);
		 u.setRating(rating);
		}
		return user;
	}

	@Override
	public User getUserById(String id) {
		User user = userRepositories.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+id));
		//calling rating service to get rating of the user
	 List<Rating>rating = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(),List.class);
	 log.info("{}",rating);
	 user.setRating(rating);
		return user;
	}

}
