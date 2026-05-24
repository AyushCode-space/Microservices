package com.userService.UserService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userService.UserService.entities.DTO.ApiResponseDTO;

@RestControllerAdvice
public class GlobalException {
     
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		ApiResponseDTO apiResponseDTO = new ApiResponseDTO(message, true, HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponseDTO>(apiResponseDTO, HttpStatus.NOT_FOUND);
	}
}
