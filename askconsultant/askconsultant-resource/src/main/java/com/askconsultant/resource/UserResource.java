package com.askconsultant.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	
	@POST
	public Response register(final String json) throws Exception {
		logger.debug("User login");
		
		return null;
	}
	
	

}
