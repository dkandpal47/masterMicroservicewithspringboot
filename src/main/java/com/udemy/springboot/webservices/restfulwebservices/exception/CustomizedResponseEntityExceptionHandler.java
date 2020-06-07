package com.udemy.springboot.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.udemy.springboot.webservices.restfulwebservices.user.UserNotFoundException;

//Let say we want to use this exception to all controller

@ControllerAdvice
//Rest Controller as it would be response in case of exception in rest call
@RestController
public class CustomizedResponseEntityExceptionHandler 
extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		
		//So that every response of exception ould have predefined structure.
		ExceptionResponse eResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<Object>(eResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*Now to handle UserNotFoundException this function will work, 
	 * Giving standardize format of error
	 * Specific Error code for specific exception
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		
		//So that every response of exception ould have predefined structure.
		ExceptionResponse eResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(eResponse, HttpStatus.NOT_FOUND);
	}
}
