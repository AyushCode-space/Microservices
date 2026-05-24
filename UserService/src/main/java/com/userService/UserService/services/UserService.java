package com.userService.UserService.services;

import java.util.List;

import com.userService.UserService.entities.User;

public interface UserService {
     
	public User createUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUserById(String id);
	
}
