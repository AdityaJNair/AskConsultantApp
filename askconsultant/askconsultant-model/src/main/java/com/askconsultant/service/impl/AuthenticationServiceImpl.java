package com.askconsultant.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Base64;

import javax.inject.Inject;

import com.askconsultant.dao.EmployeeDAO;
import com.askconsultant.dao.RegistrationDAO;
import com.askconsultant.dao.UserDAO;
import com.askconsultant.exception.InvalidUserException;
import com.askconsultant.model.Employee;
import com.askconsultant.service.AuthenticationService;
import com.askconsultant.service.RegistrationService;
import com.askconsultant.service.dto.User;

/**
 * This class contains implementation for authentication of users, creating secure tokens 
 * and validating the token created previously
 */
public class AuthenticationServiceImpl implements AuthenticationService {

	private static final String DELIMITER_DOLLAR = "\\$";
	private static final String USER_DOES_NOT_EXIST = "User does not exist";
	private static final String USER_ID_OR_PASSWORD_ERROR = "User ID or Password Error";
	private static final String DOLLAR = "$";
	private static final String UTF_8 = "utf-8";

	@Inject
	UserDAO userDAO;

	@Inject
	EmployeeDAO employeeDAO;
	
	@Inject
	RegistrationDAO registrationDAO;
	
	@Inject
	RegistrationService registrationService;

	/* (non-Javadoc)
	 * @see com.askconsultant.service.AuthenticationService#isAuthenticated(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isAuthenticated(String userid, String auth) {
		boolean isValid = false;
		byte[] decodedToken = Base64.getDecoder().decode(auth);
		try {
			String token = new String(decodedToken, UTF_8);
			String[] split = token.split(DELIMITER_DOLLAR);
			String user = split[0];
			String loginTime = split[1];
			if (LocalDateTime.parse(loginTime).plusMinutes(20L).isBefore(LocalDateTime.now())) {
				isValid = true;
			}
		} catch (Exception e) {
			isValid=false;
		}
		return isValid;
	}

	/* (non-Javadoc)
	 * @see com.askconsultant.service.AuthenticationService#login(com.askconsultant.service.dto.User)
	 */
	@Override
	public User login(User user) throws Exception {
		try {
			User userDTO = new User();
			String password;
			if (user.isEmployee()) {
				Employee dbEmployee = employeeDAO.getEmployeeByUserID(user.getUserID());
				password = dbEmployee.getPassword();
			} else {
				com.askconsultant.model.User dbUser = userDAO.getUserByUserID(user.getUserID());
				password = dbUser.getPassword();
			}
			if (password.equals(this.encryptPassword(user.getPassword()))) {
				userDTO.setPreferredName(registrationService.getDisplayOrPreferredName(user.getUserID()));
				userDTO.setToken(createSecureTokenForUser(user.getUserID()));
				userDTO.setUserID(user.getUserID());
				return userDTO;
			} else
				throw new InvalidUserException(USER_ID_OR_PASSWORD_ERROR);
		} catch (InvalidUserException ue) {
			throw new InvalidUserException(USER_DOES_NOT_EXIST);
		} catch (Exception otherException) {
			throw otherException;
		}
	}

	/**
	 * Returns encrypted password
	 * @param unencryptedPassword
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public String encryptPassword(String unencryptedPassword) throws NoSuchAlgorithmException {
		String encryptedPassword = RegistrationServiceImpl.sha1(unencryptedPassword);
		return encryptedPassword;
	}

	/* (non-Javadoc)
	 * @see com.askconsultant.service.AuthenticationService#isEmployee(java.lang.String)
	 */
	@Override
	public boolean isEmployee(String userid) {
		boolean isEmployee = false;
		try {
			employeeDAO.getEmployeeByUserID(userid);
			return true;
		} catch (Exception e) {
			isEmployee = false;
		}
		return isEmployee;
	}

	/**
	 * Creates Secure login token for successful login
	 * @param userid
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String createSecureTokenForUser(String userid) throws UnsupportedEncodingException {
		String dateTime = LocalDateTime.now().toString();
		String token = new StringBuffer(userid).append(DOLLAR).append(dateTime).toString();
		String base64encodedString = Base64.getEncoder().encodeToString(token.getBytes(UTF_8));
		return base64encodedString;
	}
	
	/**
	 * @param userid
	 * @return
	 */
	public User getGenericDetailsForUserOrEmployee(String userid) {
		User user = new User();
		return user;
	}

}
