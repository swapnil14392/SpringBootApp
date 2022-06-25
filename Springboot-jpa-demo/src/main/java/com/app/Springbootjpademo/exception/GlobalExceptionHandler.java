package com.app.Springbootjpademo.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  {
	@ExceptionHandler(value = DataNotFoundException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse dataNotFoundException(WebRequest request,DataNotFoundException e) {
		return new ErrorResponse(LocalDateTime.now(),HttpStatus.BAD_REQUEST.value(), e.getMessage());
		
	}
}
