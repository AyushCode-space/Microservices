package com.hotelService.hotelService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hotels")
public class Hotel {
    
	@Id
	private String id;
	private String name;
	private String location;
	private String about;
    
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public String getAbout() {
		return about;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
}
