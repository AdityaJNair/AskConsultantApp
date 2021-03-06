package com.askconsultant.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.askconsultant.dao.EmployeeDAO;
import com.askconsultant.dao.RegistrationDAO;
import com.askconsultant.dao.UserDAO;
import com.askconsultant.exception.EmployeeExistsException;
import com.askconsultant.model.Employee;
import com.askconsultant.model.RegistrationDetails;
import com.askconsultant.model.User;
import com.askconsultant.service.RegistrationService;

/**
 * This class implements services for login and registration of users
 *
 */
@Stateless
public class RegistrationServiceImpl implements RegistrationService {

	private static final String EMPLOYEE_IS_ALREADY_REGISTERED = "Employee is already registered";
	private static final String SHA1 = "SHA1";
	private static final String ACTIVE = "ACTIVE";

	@Inject
	UserDAO userDAO;

	@Inject
	RegistrationDAO registrationDAO;

	@Inject
	EmployeeDAO employeeDAO;

	public RegistrationServiceImpl() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.askconsultant.service.RegistrationService#register(com.askconsultant.
	 * service.dto.User)
	 */
	public void register(com.askconsultant.service.dto.User userDetails) throws Exception {

		User user = new User();
		String password = userDetails.getPassword();
		user.setPassword(sha1(password));
		user.setUserid(userDetails.getUserID());
		user.setSource(userDetails.getSource());
		user.setIndustry(userDetails.getIndustry());
		user.setInterest(userDetails.getInterest());
		user.setStatus(ACTIVE);

		RegistrationDetails regDetails = new RegistrationDetails();
		regDetails.setDateOfBirth(userDetails.getDateOfBirth());
		regDetails.setEmail(userDetails.getEmail());
		regDetails.setFirstName(userDetails.getFirstName());
		regDetails.setLastName(userDetails.getLastName());
		regDetails.setOccupation(userDetails.getOccupation());
		regDetails.setGender(userDetails.getGender());
		regDetails.setPreferredName(userDetails.getPreferredName());
		regDetails.setUserid(userDetails.getUserID());

		userDAO.addUser(user);
		registrationDAO.addRegistrationDetails(regDetails);
	}

	/**
	 * Encrypts password using SHA1 algorithm
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	static String sha1(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance(SHA1);
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see com.askconsultant.service.RegistrationService#registerEmployee(com.askconsultant.service.dto.User)
	 */
	@Override
	public void registerEmployee(com.askconsultant.service.dto.User userDetails) throws Exception {
		
		if(employeeDAO.isEmployeeRegistered(userDetails.getUserID())) {
			throw new EmployeeExistsException(EMPLOYEE_IS_ALREADY_REGISTERED);
		}
		Employee employee = new Employee();
		employee.setUserid(userDetails.getUserID());
		employee.setPassword(sha1(userDetails.getPassword()));
		employee.setName(userDetails.getName());
		employee.setRole(userDetails.getRole());
		employee.setPrimaryTopic(userDetails.getPrimaryTopic());
		employee.setPrimarySubTopic(userDetails.getPrimarySubTopic());
		employeeDAO.addEmployee(employee);
		
		//add the common details to the registration table
		//this will make it easier for the conversation/message api to get the required details in just one database call
		RegistrationDetails regDetails = new RegistrationDetails();
		regDetails.setPreferredName(userDetails.getName());
		regDetails.setUserid(userDetails.getUserID());
		registrationDAO.addRegistrationDetails(regDetails);
	}

	/**
	 * @param userid
	 * @return
	 */
	@Override
	public String getDisplayOrPreferredName(String userid) {
		String displayName="";
		RegistrationDetails registrationDetails = registrationDAO.findByUserID(userid);
		if(null!=registrationDetails) {
			String preferredName = registrationDetails.getPreferredName();
			if(preferredName!=null && !preferredName.isEmpty()) {
				displayName = registrationDetails.getPreferredName();
			}else {
				displayName = registrationDetails.getFirstName() + " " + registrationDetails.getLastName();
			}
		}
		return displayName;
	}
	
}
