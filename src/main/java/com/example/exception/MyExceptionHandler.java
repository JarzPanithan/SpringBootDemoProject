package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class MyExceptionHandler extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public MyExceptionHandler() {
		super();
	}
	
	public MyExceptionHandler(final String message) {
		super(message);
	}
}
