package com.exceptions;

public class PatientException extends Exception {
	String message="";
	public PatientException(String message) {
		super(message);
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
	
}
