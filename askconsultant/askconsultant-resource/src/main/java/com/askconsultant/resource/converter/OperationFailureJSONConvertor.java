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

	public JsonElement convertToJsonElement(final String error){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("error", error);
		return jsonObject;
	}
}
