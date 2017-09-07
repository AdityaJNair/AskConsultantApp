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

import com.askconsultant.common.ResourceConstants;
import com.askconsultant.resource.converter.OperationFailureJSONConvertor;
import com.askconsultant.resource.converter.RegistrationJSONConverter;
import com.askconsultant.service.RegistrationService;

/**
 * Contains methods for managing registration 
 *
 */
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

	
	/**
	 * Registers the user with the information in the json payload
	 * @param json
	 * @return
	 * @throws Exception
	 */
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
