package com.askconsultant.resource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.askconsultant.common.FileUtil;
import com.askconsultant.common.UserHelper;
import com.askconsultant.exception.InvalidUserException;
import com.askconsultant.resource.converter.OperationFailureJSONConvertor;
import com.askconsultant.resource.converter.SessionJSONConverter;
import com.askconsultant.service.AuthenticationService;

public class TestSessionResource {

	SessionResource sessionResource;
	AuthenticationService authService;
	SessionJSONConverter sessionJSONConverter;
	OperationFailureJSONConvertor opFailureJSONConverter;

	@Before
	public void init() {
		sessionResource = new SessionResource();
		// mocks
		sessionJSONConverter = mock(SessionJSONConverter.class);
		authService = mock(AuthenticationService.class);
		opFailureJSONConverter = mock(OperationFailureJSONConvertor.class);
		//set the mocks
		sessionResource.sessionJSONConverter = sessionJSONConverter;
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
			when(authService.login(Mockito.anyVararg())).thenReturn(UserHelper.returnValidUser());
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
			when(authService.login(Mockito.anyVararg())).thenAnswer(invocation -> {
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
