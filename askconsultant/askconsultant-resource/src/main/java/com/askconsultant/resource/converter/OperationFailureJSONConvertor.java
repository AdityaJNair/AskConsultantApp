package com.askconsultant.resource.converter;

import javax.enterprise.context.ApplicationScoped;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Contains methods for converting to and from JSON to OperationFailureException
 *
 */
@ApplicationScoped
public class OperationFailureJSONConvertor {

	private static final String ERROR2 = "error";

	public JsonElement convertToJsonElement(final String error){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(ERROR2, error);
		return jsonObject;
	}
}
