package com.askconsultant.service.impl;

import com.askconsultant.service.AuthenticationService;
import com.askconsultant.service.dto.User;

public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public boolean isAuthenticated(String auth) {
		return true;
	}

	@Override
	public User login(User user) {
		//authenticate the user with the database
		//get the User model and assign the required values to the UserDTO
		User userdto = new User();
		//logic to create the token
		userdto.setToken("securetoken");
		return userdto;
	}

}
