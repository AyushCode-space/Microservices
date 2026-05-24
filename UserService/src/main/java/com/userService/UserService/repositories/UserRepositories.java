package com.userService.UserService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userService.UserService.entities.User;

public interface UserRepositories extends JpaRepository<User, String> {
   
	
}
