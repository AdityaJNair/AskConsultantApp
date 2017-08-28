package com.askconsultant.service;

import javax.ejb.Local;

import com.askconsultant.service.dto.User;

@Local
public interface AuthenticationService {
	
	public boolean isAuthenticated(String auth);
	
	public User login(User user);

}
