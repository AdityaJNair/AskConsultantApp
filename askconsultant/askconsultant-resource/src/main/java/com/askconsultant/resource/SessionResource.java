package com.askconsultant.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.askconsultant.common.json.JsonWriter;
import com.askconsultant.exception.InvalidUserException;
import com.askconsultant.resource.converter.OperationFailureJSONConvertor;
import com.askconsultant.resource.converter.SessionJSONConverter;
import com.askconsultant.service.AuthenticationService;
import com.askconsultant.service.dto.User;

@Path("/session")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class SessionResource {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	AuthenticationService authService;
	
	@Inject
	SessionJSONConverter sessionJSONConverter;
	
	@Inject
	OperationFailureJSONConvertor opFailureJSONConverter;
	
	@POST
	public Response createSession(final String json) {
		logger.debug("User login");
		User user;
		try {
			user = sessionJSONConverter.convert(json);
			User loginResponse = authService.login(user);
			return Response.status(201)
					.entity(JsonWriter.writeToString(sessionJSONConverter.convertToJsonElement(loginResponse))).build();
		} catch (InvalidUserException e) {
			return Response.status(401)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement(e.getMessage()))).build();
		} catch (Exception e) {
			return Response.status(201)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement(e.getMessage()))).build();
		}
		
	}
	
}
