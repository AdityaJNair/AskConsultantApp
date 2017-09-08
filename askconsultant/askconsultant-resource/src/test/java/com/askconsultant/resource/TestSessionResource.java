package com.askconsultant.resource;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.askconsultant.common.FileUtil;
import com.askconsultant.common.UserHelper;
import com.askconsultant.exception.InvalidUserException;
import com.askconsultant.resource.converter.OperationFailureJSONConvertor;
import com.askconsultant.resource.converter.SessionJSONConverter;
import com.askconsultant.service.AuthenticationService;
import com.askconsultant.service.dto.User;

public class TestSessionResource {

	SessionResource sessionResource;
	AuthenticationService authService;
	SessionJSONConverter sessionJSONConverter;
	OperationFailureJSONConvertor opFailureJSONConverter;

	@Before
	public void init() {
		sessionResource = new SessionResource();
		sessionJSONConverter = new SessionJSONConverter();
		sessionResource.sessionJSONConverter = sessionJSONConverter;
		// mocks
		authService = mock(AuthenticationService.class);
		opFailureJSONConverter = mock(OperationFailureJSONConvertor.class);
		sessionResource.authService = mock(AuthenticationService.class);
		sessionResource.opFailureJSONConverter = mock(OperationFailureJSONConvertor.class);
	}

	/**
	 * Tests the creation of the session for a success scenario
	 */
	@Test
	public void createSession() {
		String readJSONFile = FileUtil.readJSONFile("TEST1_SESSION_REQUEST.json");
		try {
			when(authService.login(any(User.class))).thenReturn(UserHelper.returnValidUser());
			//call the actual method
			Response response = sessionResource.createSession(readJSONFile);
			assertNotNull(response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	/**
	 * Tests the creation of the session for a invalid user
	 */
	@Test
	public void createSession_InvalidUserException() {
		String readJSONFile = FileUtil.readJSONFile("TEST1_SESSION_REQUEST.json");
		try {
			when(authService.login(any(User.class))).thenAnswer(invocation -> {
				   throw new InvalidUserException("Invalid user");
			});
			//call the actual method
			Response response = sessionResource.createSession(readJSONFile);
			assertNotNull(response);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

}
