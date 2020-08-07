package com.example.model;

import java.time.LocalDateTime;

public class ErrorDetails {
	private int errorCode;
	private String errorMessage;
	private LocalDateTime timeStamp;
	private String message;
	
	public ErrorDetails() {
		super();
	}
	
	public ErrorDetails(LocalDateTime timeStamp) {
		super();
		this.timeStamp = timeStamp;
	}
	
	public ErrorDetails(int errorCode, String errorMessage, String message) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.message = message;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
