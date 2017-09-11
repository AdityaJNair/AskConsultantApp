package com.askconsultant.common;

import org.junit.Ignore;

import com.askconsultant.service.dto.User;

/**
 * Provides helper methods to return User objects related to session
 * management
 */
@Ignore
public class SessionHelper {

	/**
	 * Returns a new User object
	 * 
	 * @param userid
	 * @param password
	 * @param isEmployee
	 * @return
	 */
	public static User getSessionObject(String userid, String password, boolean isEmployee) {
		User user = new User();
		user.setUserID(userid);
		user.setPassword(password);
		user.setEmployee(isEmployee);;
		return user;
	}
}
