package com.askconsultant.resource.converter;

import com.askconsultant.model.Message;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class OperationFailureJSONConvertor {

	public JsonElement convertToJsonElement(final String error){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("error", error);
		return jsonObject;
	}
}
