package com.askconsultant.resource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.askconsultant.common.ResourceConstants;
import com.askconsultant.common.json.JsonWriter;
import com.askconsultant.exception.InvalidUserException;
import com.askconsultant.model.RegistrationDetails;
import com.askconsultant.model.User;
import com.askconsultant.resource.converter.OperationFailureJSONConvertor;
import com.askconsultant.resource.converter.RegistrationJSONConverter;
import com.askconsultant.service.RegistrationService;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
	
	
	@Inject
	RegistrationJSONConverter registrationJSONConverter;
	
	@Inject
	OperationFailureJSONConvertor opFailureJSONConverter;
	
	@Inject 
	RegistrationService registrationService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	
	@POST
	public Response register(final String json) throws Exception {
		logger.debug("User login");

		com.askconsultant.service.dto.User userDetails = registrationJSONConverter.convert(json);
		registrationService.register(userDetails);
		
		try{
			
			return Response.status(ResourceConstants.HTTP_RESPONSE_OK).build();
		}  catch (Exception e) {
			return Response.status(ResourceConstants.HTTP_RESPONSE_GENERIC_ERROR).build();
		}
	}
    
	
	

}
