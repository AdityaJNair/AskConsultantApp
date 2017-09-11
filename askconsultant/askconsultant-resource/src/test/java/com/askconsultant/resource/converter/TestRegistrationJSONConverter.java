package com.askconsultant.resource.converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.askconsultant.common.FileUtil;
import com.askconsultant.common.UserHelper;
import com.askconsultant.model.RegistrationDetails;
import com.askconsultant.service.dto.User;
import com.google.gson.JsonElement;

public class TestRegistrationJSONConverter {

	RegistrationJSONConverter registrationJSONConverter;

	@Before
	public void init() {
		registrationJSONConverter = new RegistrationJSONConverter();
	}

	/**
	 * Tests the conversion of JSON request to Registration object
	 */
	@Test
	public void convert() {
		try {
			String jsonRequest = FileUtil.readJSONFile("TEST1_USER_REGISTRATION_REQUEST_JSON.json");
			User user = registrationJSONConverter.convert(jsonRequest);
			assertNotNull(user);
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Tests the conversion of JSON request to Employee registration details request
	 */
	@Test
	public void convertEmployeeRegistrationJSON() {
		try {
			String request = FileUtil.readJSONFile("TEST1_USER_REGISTRATION_REQUEST_JSON.json");
			User employeeRegistrationJSON = registrationJSONConverter.convertEmployeeRegistrationJSON(request);
			assertNotNull(employeeRegistrationJSON);
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Tests the conversion of User object to JSON object
	 */
	@Test
	public void convertToJsonElementForUserObject() {
		try {
			com.askconsultant.model.User user = UserHelper.returnValidUserWithAdditionalDetails("userid", "password",
					"industry", "source", "status");
			JsonElement jsonElement = registrationJSONConverter.convertToJsonElement(user);
			assertNotNull(jsonElement);
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Tests the conversion of Registration object to JSON object
	 */
	@Test
	public void convertToJsonElement() {
		try {
			RegistrationDetails registrationDetails = UserHelper.getRegistrationObject("firstname", "lastname",
					"preferredName", "email", "occupation", "gender");
			JsonElement convertToJsonElement = registrationJSONConverter.convertToJsonElement(registrationDetails);
			assertNotNull(convertToJsonElement);
		} catch (Exception e) {
			fail();
		}
	}
}
