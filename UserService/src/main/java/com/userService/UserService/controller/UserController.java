package com.userService.UserService.controller;

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

import com.userService.UserService.entities.User;
import com.userService.UserService.services.UserService;

@RestController
@RequestMapping ("/user")
public class UserController {
    
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User createdUser = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserByID(@PathVariable(value="id") String id) {
        
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
    }
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		
		List<User> users = userService.getAllUsers();
		
		return ResponseEntity.ok(users);
	}
}
