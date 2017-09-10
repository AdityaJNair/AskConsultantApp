package com.askconsultant.common;

import org.junit.Ignore;

import com.askconsultant.service.dto.User;

@Ignore
public class UserHelper {

	public static User returnValidUser() {
		User user = new User();
		user.setFirstName("test");
		user.setPassword("password");
		user.setToken("sometoken");
		return user;
	}
}
