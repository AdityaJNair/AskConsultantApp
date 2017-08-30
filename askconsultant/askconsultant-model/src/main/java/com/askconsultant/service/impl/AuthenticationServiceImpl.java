package com.askconsultant.service.impl;

import javax.inject.Inject;

import com.askconsultant.dao.EmployeeDAO;
import com.askconsultant.dao.UserDAO;
import com.askconsultant.exception.InvalidUserException;
import com.askconsultant.model.Employee;
import com.askconsultant.service.AuthenticationService;
import com.askconsultant.service.dto.User;

public class AuthenticationServiceImpl implements AuthenticationService {

	@Inject
	private UserDAO userDAO;

	@Inject
	private EmployeeDAO employeeDAO;

	@Override
	public boolean isAuthenticated(String auth) {
		return true;
	}

	@Override
	public User login(User user) {
		try {
			if (user.isEmployee()) {
				Employee dbEmployee = employeeDAO.getEmployeeByUserID(user.getUserID());
			} else {
				com.askconsultant.model.User dbUser = userDAO.getUserByUserID(user.getUserID());
			}
		} catch (InvalidUserException ue) {
			throw new InvalidUserException("Invalid user");
		}
		User userDTO = new User();
		userDTO.setToken("securetoken");
		userDTO.setUserID(user.getUserID());
		return userDTO;

	}

}
