package com.askconsultant.common;

import com.askconsultant.service.dto.User;

public class UserHelper {

	public static User returnValidUser() {
		User user = new User();
		user.setFirstName("test");
		user.setPassword("password");
		user.setToken("sometoken");
		return user;
	}
}
