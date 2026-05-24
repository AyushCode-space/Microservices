package com.userService.UserService.entities.DTO;

import org.springframework.http.HttpStatus;

public class ApiResponseDTO {
   
	private String message;
	private boolean success;
	private HttpStatus status;
	public String getMessage() {
		return message;
	}
	public boolean isSuccess() {
		return success;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public ApiResponseDTO(String message, boolean success, HttpStatus status) {
		super();
		this.message = message;
		this.success = success;
		this.status = status;
	}
	
	
}
