package com.askconsultant.exception;

public class EmployeeExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeExistsException(String message) {
		super(message);
	}

}
