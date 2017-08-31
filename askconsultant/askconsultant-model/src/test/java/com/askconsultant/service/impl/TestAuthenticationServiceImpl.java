package com.askconsultant.service.impl;

import org.junit.Before;
import org.junit.Test;

import com.askconsultant.dao.EmployeeDAO;
import com.askconsultant.dao.UserDAO;
import com.askconsultant.exception.InvalidUserException;
import com.askconsultant.service.AuthenticationService;
import com.askconsultant.service.dto.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestAuthenticationServiceImpl {

	private AuthenticationService authenticationService;
	private UserDAO userDAO;
	private EmployeeDAO employeeDAO;
	
	
	@Before
	public void init(){
		authenticationService = new AuthenticationServiceImpl();
		userDAO = mock(UserDAO.class);
		employeeDAO = mock(EmployeeDAO.class);
		((AuthenticationServiceImpl)authenticationService).userDAO = userDAO;
		((AuthenticationServiceImpl)authenticationService).employeeDAO = employeeDAO;
	}
	
	@Test
	public void login_ValidUser(){
		User user = getUserForValidUser();
		user.setEmployee(false);
		//set the mock expectations
		when(userDAO.getUserByUserID(user.getUserID())).thenReturn(getDBUser());
		when(employeeDAO.getEmployeeByUserID(user.getUserID())).thenReturn(getDBEmployee());
		try{
			User login = authenticationService.login(user);
			assertNotNull(login);
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void login_InvalidUser(){
		User user = getUserForValidUser();
		user.setEmployee(false);
		//set the mock expectations
		when(userDAO.getUserByUserID(user.getUserID())).thenThrow((new InvalidUserException("User does not exist")));
		try{
			authenticationService.login(user);
			fail();
		}catch(Exception e){
			assertEquals("User does not exist", e.getMessage());
		}
	}
	
	@Test
	public void login_InvalidEmployee(){
		User user = getUserForValidUser();
		user.setEmployee(true);
		//set the mock expectations
		when(employeeDAO.getEmployeeByUserID(user.getUserID())).thenThrow((new InvalidUserException("User does not exist")));
		try{
			authenticationService.login(user);
			fail();
		}catch(Exception e){
			assertEquals("User does not exist", e.getMessage());
		}
	}
	
	@Test
	public void login_ValidEmployee(){
		User user = getUserForValidUser();
		user.setEmployee(true);
		//set the mock expectations
		when(userDAO.getUserByUserID(user.getUserID())).thenReturn(getDBUser());
		when(employeeDAO.getEmployeeByUserID(user.getUserID())).thenReturn(getDBEmployee());
		try{
			User login = authenticationService.login(user);
			assertNotNull(login);
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	private User getUserForValidUser() {
		User user = new User();
		user.setEmployee(false);
		user.setUserID("someID");
		return user;
	}
	
	private com.askconsultant.model.User getDBUser(){
		com.askconsultant.model.User dbUser = new com.askconsultant.model.User();
		dbUser.setPassword("encryptedPassword");
		return dbUser;
	}
	
	private com.askconsultant.model.Employee getDBEmployee(){
		com.askconsultant.model.Employee dbEmployee = new com.askconsultant.model.Employee();
		dbEmployee.setPassword("encryptedPassword");
		return dbEmployee;
	}
}
