package com.askconsultant.resource;

import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.askconsultant.common.ResourceConstants;
import com.askconsultant.common.json.JsonWriter;
import com.askconsultant.resource.converter.EmployeeCategoriesConverter;
import com.askconsultant.resource.converter.OperationFailureJSONConvertor;
import com.askconsultant.service.EmployeeService;

@Path("employees/{userid}/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeCategoriesResource {

	private static final String INTERNAL_ERROR = "Internal Error";

	@Inject
	OperationFailureJSONConvertor opFailureJSONConverter;

	@Inject
	EmployeeService employeeService;

	@Inject
	EmployeeCategoriesConverter employeeTopicsConverter;

	/**
	 * Lists all categories for a user, applicable for an employee
	 * 
	 * @param conversationid
	 * @return
	 */
	@GET
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
					.entity(JsonWriter.writeToString(opFailureJSONConverter.convertToJsonElement(INTERNAL_ERROR)))
					.build();
		}
	}
}
