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

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class TestAuthenticationServiceImpl {

	private AuthenticationService authenticationService;
	private UserDAO userDAO;
	private EmployeeDAO employeeDAO;

	@Before
	public void init() {
		authenticationService = new AuthenticationServiceImpl();
		userDAO = mock(UserDAO.class);
		employeeDAO = mock(EmployeeDAO.class);
		((AuthenticationServiceImpl) authenticationService).userDAO = userDAO;
		((AuthenticationServiceImpl) authenticationService).employeeDAO = employeeDAO;
	}

	@Test
	public void login_ValidUser() {
		User user = getUserForValidUser();
		user.setEmployee(false);
		try {
			// set the mock expectations
			when(userDAO.getUserByUserID(user.getUserID())).thenReturn(getDBUser());
			when(employeeDAO.getEmployeeByUserID(user.getUserID())).thenReturn(getDBEmployee());
			User login = authenticationService.login(user);
			assertNotNull(login);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void login_InvalidUser() {
		User user = getUserForValidUser();
		user.setEmployee(false);
		// set the mock expectations
		try {
			when(userDAO.getUserByUserID(user.getUserID())).thenThrow((new InvalidUserException("User does not exist")));
			authenticationService.login(user);
			fail();
		} catch (Exception e) {
			assertEquals("User does not exist", e.getMessage());
		}
	}

	@Test
	public void login_InvalidEmployee() {
		User user = getUserForValidUser();
		user.setEmployee(true);
		// set the mock expectations
		try {
			when(employeeDAO.getEmployeeByUserID(user.getUserID()))
			.thenThrow((new InvalidUserException("User does not exist")));
			authenticationService.login(user);
			fail();
		} catch (Exception e) {
			assertEquals("User does not exist", e.getMessage());
		}
	}

	@Test
	public void login_ValidEmployee() {
		User user = getUserForValidUser();
		user.setEmployee(true);
		try {
			// set the mock expectations
			when(userDAO.getUserByUserID(user.getUserID())).thenReturn(getDBUser());
			when(employeeDAO.getEmployeeByUserID(user.getUserID())).thenReturn(getDBEmployee());
			User login = authenticationService.login(user);
			assertNotNull(login);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void createSecureTokenForUser() {
		try {
			String createSecureTokenForUser = AuthenticationServiceImpl.createSecureTokenForUser("userid");
			System.out.println(createSecureTokenForUser);
			assertTrue(createSecureTokenForUser.length()!=0);
		} catch (UnsupportedEncodingException e) {
			fail();
		}
	}
	
	@Test 
	public void isAuthenticated() {
		try {
			String createSecureTokenForUser = AuthenticationServiceImpl.createSecureTokenForUser("userid");
			boolean authenticated = authenticationService.isAuthenticated("userid", createSecureTokenForUser);
			assertNotNull(authenticated);
		} catch (UnsupportedEncodingException e) {
			fail();
		}
	}
	
	
	private User getUserForValidUser() {
		User user = new User();
		user.setEmployee(false);
		user.setUserID("someID");
		user.setPassword("password");
		return user;
	}

	private com.askconsultant.model.User getDBUser() throws NoSuchAlgorithmException {
		com.askconsultant.model.User dbUser = new com.askconsultant.model.User();
		dbUser.setPassword(RegistrationServiceImpl.sha1("password"));
		return dbUser;
	}

	private com.askconsultant.model.Employee getDBEmployee() throws NoSuchAlgorithmException {
		com.askconsultant.model.Employee dbEmployee = new com.askconsultant.model.Employee();
		dbEmployee.setPassword(RegistrationServiceImpl.sha1("password"));
		return dbEmployee;
	}
	
	
}
