package com.askconsultant.resource;

import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.askconsultant.common.ResourceConstants;
import com.askconsultant.common.json.JsonWriter;
import com.askconsultant.exception.EmployeeExistsException;
import com.askconsultant.resource.converter.EmployeeCategoriesConverter;
import com.askconsultant.resource.converter.OperationFailureJSONConvertor;
import com.askconsultant.resource.converter.RegistrationJSONConverter;
import com.askconsultant.service.EmployeeService;
import com.askconsultant.service.RegistrationService;

/**
 * Contains methods for managing registration for employee
 *
 */
@Path("/admin/employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	@Inject
	RegistrationJSONConverter registrationJSONConverter;

	@Inject
	OperationFailureJSONConvertor opFailureJSONConverter;

	@Inject
	RegistrationService registrationService;
	
	@Inject
	EmployeeService employeeService;

	@Inject
	EmployeeCategoriesConverter employeeTopicsConverter;

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Registers the user with the information in the json payload
	 * 
	 * @param json
	 */
	@POST
	public Response register(final String json) {
		logger.debug("Registering employee");

		try {
			com.askconsultant.service.dto.User userDetails = registrationJSONConverter
					.convertEmployeeRegistrationJSON(json);
			registrationService.registerEmployee(userDetails);
			return Response.status(ResourceConstants.HTTP_RESPONSE_OK).build();
		} catch (EmployeeExistsException e) {
			return Response.status(ResourceConstants.HTTP_RESPONSE_GENERIC_ERROR)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement(e.getMessage())))
					.build();
		} catch (Exception e) {
			return Response.status(ResourceConstants.HTTP_RESPONSE_GENERIC_ERROR).build();
		}
	}
	
	/**
	 * Lists all categories for a user, applicable for an employee
	 * 
	 * @param conversationid
	 * @return
	 */
	@GET
	@Path("{userid}/categories")
	public Response listCategories(@PathParam("userid") String userid) {
		try {
			Map<String, String> employeeConversationCategories = employeeService
					.getEmployeeConversationCategories(userid);
			return Response.status(201).entity(JsonWriter
					.writeToString(employeeTopicsConverter.convertToJsonElement(employeeConversationCategories)))
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(ResourceConstants.HTTP_RESPONSE_GENERIC_ERROR)
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement("Internal Error")))
					.build();
		}
	}
}
