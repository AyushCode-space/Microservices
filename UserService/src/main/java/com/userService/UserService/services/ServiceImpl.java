package com.userService.UserService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userService.UserService.entities.User;
import com.userService.UserService.exception.ResourceNotFoundException;
import com.userService.UserService.repositories.UserRepositories;

@Service
public class ServiceImpl implements UserService{
    
	@Autowired
	private UserRepositories userRepositories;
	
	@Override
	public User createUser(User user) {
		String id = UUID.randomUUID().toString();
           user.setUserId(id);
		return userRepositories.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepositories.findAll() ;
	}

	@Override
	public User getUserById(String id) {
		
		return userRepositories.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+id));
	}

}
