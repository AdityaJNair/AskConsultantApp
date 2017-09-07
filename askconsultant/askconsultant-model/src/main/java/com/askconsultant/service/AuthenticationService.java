package com.askconsultant.service;

import javax.ejb.Local;

import com.askconsultant.service.dto.User;

/**
 * Interface for Authentication services
 */
@Local
public interface AuthenticationService {
	
	/**
	 * Checks if the user is a valid user based on the secure token
	 * @param userid
	 * @param auth
	 * @return
	 */
	public boolean isAuthenticated(String userid, String auth);
	
	/**
	 * Creates a session for a valid user
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception;
	
	/**
	 * Checks if the user is an employee
	 * @param userid
	 * @return
	 */
	public boolean isEmployee(String userid);


}
