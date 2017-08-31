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
	UserDAO userDAO;

	@Inject
	EmployeeDAO employeeDAO;

	@Override
	public boolean isAuthenticated(String auth) {
		return true;
	}

	@Override
	public User login(User user) throws Exception{
		try {
			String password;
			if (user.isEmployee()) {
				Employee dbEmployee = employeeDAO.getEmployeeByUserID(user.getUserID());
				password = dbEmployee.getPassword();
			} else {
				com.askconsultant.model.User dbUser = userDAO.getUserByUserID(user.getUserID());
				password = dbUser.getPassword();
			}
			if(password.equals(this.encryptPassword(user.getPassword()))){
				User userDTO = new User();
				userDTO.setToken("securetoken");
				userDTO.setUserID(user.getUserID());
				return userDTO;
			}
			else throw new InvalidUserException("User ID or Password Error");
		} catch (InvalidUserException ue) {
			throw new InvalidUserException("User does not exist");
		} catch (Exception otherException) {
			throw otherException;
		}
	}
	
	public String encryptPassword(String unencryptedPassword){
		//TODO: Nathan/Dom will be implementing this
		return "encryptedPassword";
	}
}
