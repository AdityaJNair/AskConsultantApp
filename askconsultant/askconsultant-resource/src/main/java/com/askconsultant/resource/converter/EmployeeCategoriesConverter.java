package com.askconsultant.resource.converter;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Converter class from and to JSON for Conversation categories
 *
 */
@ApplicationScoped
public class EmployeeCategoriesConverter {

	private static final String PRIMARY_SUBTOPIC = "primarySubtopic";
	private static final String PRIMARY_TOPIC = "primaryTopic";

	/**
	 * Converts the topics and subtopics from map to JSON
	 * @param topicsAndSubtopics
	 * @return
	 */
	public JsonElement convertToJsonElement(final Map<String,String> topicsAndSubtopics){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(PRIMARY_TOPIC,topicsAndSubtopics.get(PRIMARY_TOPIC) );
		jsonObject.addProperty(PRIMARY_SUBTOPIC, topicsAndSubtopics.get(PRIMARY_SUBTOPIC));
		return jsonObject;
	}
}
