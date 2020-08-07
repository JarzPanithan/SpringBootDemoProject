package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundHandler extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundHandler() {
		super();
	}
	
	public ProductNotFoundHandler(final Long id) {
		super("Product id: " + id + " not found!!");
	}
	
	public ProductNotFoundHandler(final String name) {
		super("Product name: " + name + " not found!!");
	}
}
