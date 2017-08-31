package com.askconsultant.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.askconsultant.dao.RegistrationDAO;
import com.askconsultant.dao.UserDAO;
import com.askconsultant.model.RegistrationDetails;
import com.askconsultant.model.User;
import com.askconsultant.service.RegistrationService;

@Stateless
public class RegistrationServiceImpl implements RegistrationService {
	
	@Inject
	UserDAO userDAO;
	
	@Inject
	RegistrationDAO registrationDAO;
	
	public RegistrationServiceImpl(){
		
	}
	
	public void register(com.askconsultant.service.dto.User userDetails) throws Exception{
		
		User user = new User();
		String password = userDetails.getPassword();
		user.setPassword(sha1(password));
		user.setUserid(userDetails.getUserID());
		user.setSource(userDetails.getSource());
		user.setIndustry(userDetails.getIndustry());
		user.setInterest(userDetails.getInterest());
		user.setStatus("ACTIVE");	
		
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
	
	static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
	
}
