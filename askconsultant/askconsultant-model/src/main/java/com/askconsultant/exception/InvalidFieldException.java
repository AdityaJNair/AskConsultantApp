package com.askconsultant.exception;

public class InvalidFieldException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final String field;
	
	public InvalidFieldException(String fieldName, String message){
		super(message);
		this.field = fieldName;
	}
	
	

}
