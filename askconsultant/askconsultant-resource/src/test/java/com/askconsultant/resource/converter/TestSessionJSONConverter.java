package com.askconsultant.resource.converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.askconsultant.common.FileUtil;
import com.askconsultant.common.SessionHelper;
import com.askconsultant.service.dto.User;
import com.google.gson.JsonElement;

/**
 * This test class tests the SessionJSONConverter class that converts Session
 * object to JSON and vice-versa.
 *
 */
public class TestSessionJSONConverter {

	SessionJSONConverter sessionJSONConverter;

	@Before
	public void init() {
		sessionJSONConverter = new SessionJSONConverter();
	}

	/**
	 * Tests the conversion of JSON request to Session object
	 */
	@Test
	public void convert() {
		try {
			String jsonFile = FileUtil.readJSONFile("TEST1_SESSION_REQUEST.json");
			User convert = sessionJSONConverter.convert(jsonFile);
			assertNotNull(convert);
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Tests the conversion of Session object to JSON element
	 */
	@Test
	public void convertToJsonElement() {
		try {
			User user = SessionHelper.getSessionObject("userid", "password", true);
			JsonElement convertToJsonElement = sessionJSONConverter.convertToJsonElement(user);
			assertNotNull(convertToJsonElement);
		} catch (Exception e) {
			fail();
		}
	}

}
