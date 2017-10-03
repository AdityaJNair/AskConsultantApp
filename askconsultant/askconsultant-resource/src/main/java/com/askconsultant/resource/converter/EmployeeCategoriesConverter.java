package com.askconsultant.resource.converter;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@ApplicationScoped
public class EmployeeCategoriesConverter {

	public JsonElement convertToJsonElement(final Map<String,String> topicsAndSubtopics){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("primaryTopic",topicsAndSubtopics.get("primaryTopic") );
		jsonObject.addProperty("primarySubtopic", topicsAndSubtopics.get("primarySubtopic"));
		return jsonObject;
	}
}
