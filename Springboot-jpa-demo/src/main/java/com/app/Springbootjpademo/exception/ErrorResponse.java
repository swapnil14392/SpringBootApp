package com.app.Springbootjpademo.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private LocalDateTime timestamp;
	private int statusCode;
    private String message;

}
