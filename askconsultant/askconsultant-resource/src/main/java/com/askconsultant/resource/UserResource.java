package com.askconsultant.resource;

import java.security.MessageDigest;

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
import com.askconsultant.common.json.JsonWriter;
import com.askconsultant.exception.InvalidUserException;
import com.askconsultant.model.RegistrationDetails;
import com.askconsultant.model.User;
import com.askconsultant.resource.converter.OperationFailureJSONConvertor;
import com.askconsultant.resource.converter.RegistrationJSONConverter;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
	
	
	@Inject
	RegistrationJSONConverter registrationJSONConverter;
	
	@Inject
	OperationFailureJSONConvertor opFailureJSONConverter;
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	
	@POST
	public Response register(final String json) throws Exception {
		logger.debug("User login");

		com.askconsultant.service.dto.User userDetails = registrationJSONConverter.convert(json);
		
		User user = new User();
		String password = userDetails.getPassword();
		user.setPassword(sha1(password));
		user.setUserid(userDetails.getUserID());
		user.setSource(userDetails.getSource());
		user.setIndustry(userDetails.getIndustry());
		user.setInterest(userDetails.getInterest());
		
		RegistrationDetails regDetails = new RegistrationDetails();
		regDetails.setDateOfBirth(userDetails.getDateOfBirth());
		regDetails.setEmail(userDetails.getEmail());
		regDetails.setFirstName(userDetails.getFirstName());
		regDetails.setLastName(userDetails.getLastName());
		regDetails.setOccupation(userDetails.getOccupation());
		regDetails.setGender(userDetails.getGender());
		regDetails.setStatus("ACTIVE");	
		
		try{
			Response userResponse = Response.status(ResourceConstants.HTTP_RESPONSE_OK)
					.entity(JsonWriter.writeToString(registrationJSONConverter.convertToJsonElementUser(user)));
			
			return Response.status(ResourceConstants.HTTP_RESPONSE_OK)
					.entity(JsonWriter.writeToString(registrationJSONConverter.convertToJsonElementReg(regDetails)));
		} catch (InvalidUserException e) {
			return Response.status(ResourceConstants.HTTP_RESPONSE_UNAUTHORIZED_ERROR)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement(e.getMessage()))).build();
		} catch (Exception e) {
			return Response.status(ResourceConstants.HTTP_RESPONSE_GENERIC_ERROR)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement(e.getMessage()))).build();
		}
	}
    static String sha1(String input) {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
	
	

}
