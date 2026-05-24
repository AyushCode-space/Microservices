package com.userService.UserService.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "micro_users")
public class User {
    
	@Id
	@Column(name = "ID")
	private String userId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ABOUT")
	private String about;
	
	@Transient
	private List<Rating> rating;
	
	public List<Rating> getRating() {
		return rating;
	}
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getAbout() {
		return about;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
}
