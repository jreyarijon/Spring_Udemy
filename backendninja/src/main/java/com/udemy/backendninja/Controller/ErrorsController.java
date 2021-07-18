package com.udemy.backendninja.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {
	
	public static final String ISE_ERROR = "/error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		
		return ISE_ERROR;
	}

}
