package com.askconsultant.service.impl;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.askconsultant.exception.InvalidFieldException;
import com.askconsultant.service.AuthenticationService;
import com.askconsultant.service.dto.User;

public class AuthenticationServiceImpl implements AuthenticationService {

	Validator validator;
	
	@Override
	public boolean isAuthenticated(String auth) {
		return true;
	}

	@Override
	public User login(User user) {
		
		Set<ConstraintViolation<User>> errors = validator.validate(user);
		Iterator<ConstraintViolation<User>> iterator = errors.iterator();
		if(iterator.hasNext()){
			ConstraintViolation<User> violation = iterator.next();
			throw new InvalidFieldException(violation.getPropertyPath().toString(), violation.getMessage());
		}
		//authenticate the user with the database
		//get the User model and assign the required values to the UserDTO
		User userdto = new User();
		//logic to create the token
		userdto.setToken("securetoken");
		return userdto;
	}

}
