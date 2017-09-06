package com.askconsultant.service;

import javax.ejb.Local;

import com.askconsultant.service.dto.User;

/**
 * Interface provide methods for user registration
 *
 */
@Local
public interface RegistrationService {

	/**
	 * Registers a user
	 * @param userDetails
	 * @throws Exception
	 */
	public void register(User userDetails) throws Exception;
}
