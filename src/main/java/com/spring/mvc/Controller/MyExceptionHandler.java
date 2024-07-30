package com.spring.mvc.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
	
	// @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = Exception.class)
	public String errorPage() {
		return  "error";
	}
	
}
