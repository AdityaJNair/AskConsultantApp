package com.askconsultant.common;

import java.util.Date;

import org.junit.Ignore;

import com.askconsultant.model.RegistrationDetails;
import com.askconsultant.service.dto.User;

/**
 * Helper class for User/Employee Registration objects
 *
 */
@Ignore
public class UserHelper {

	public static User returnValidUser() {
		User user = new User();
		user.setFirstName("test");
		user.setPassword("password");
		user.setToken("sometoken");
		return user;
	}

	public static com.askconsultant.model.User returnValidUserWithAdditionalDetails(String userid, String password,
			String industry, String source, String status) {
		com.askconsultant.model.User user = new com.askconsultant.model.User();
		user.setUserid(userid);
		user.setPassword(password);
		user.setIndustry(industry);
		user.setSource(source);
		user.setStatus(status);
		return user;
	}

	public static RegistrationDetails getRegistrationObject(String firstname, String lastname, String preferredName,
			String email, String occupation, String gender) {
		RegistrationDetails registrationDetails = new RegistrationDetails();
		registrationDetails.setFirstName(firstname);
		registrationDetails.setLastName(lastname);
		registrationDetails.setPreferredName(preferredName);
		registrationDetails.setEmail(email);
		registrationDetails.setOccupation(occupation);
		registrationDetails.setGender(gender);
		registrationDetails.setDateOfBirth(new Date());
		return registrationDetails;
	}
}
