package com.askconsultant.resource.converter;

import javax.enterprise.context.ApplicationScoped;

import com.askconsultant.common.json.JsonReader;
import com.askconsultant.service.dto.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Contains the methods to convert JSON request to java object
 *
 */
@ApplicationScoped
public class SessionJSONConverter {

	/**
	 * Method to convert json request to User object
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public User convert(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final User user = new User();
		user.setUserID(JsonReader.getStringOrNull(jsonObject, "userid"));
		user.setPassword(JsonReader.getStringOrNull(jsonObject, "password"));
		user.setEmployee((Boolean.parseBoolean(JsonReader.getStringOrNull(jsonObject, "isEmployee"))));
		return user;
	}
	
	/**
	 * Converts the user object to JSONElement
	 * @param user
	 * @return
	 */
	public JsonElement convertToJsonElement(final com.askconsultant.service.dto.User user){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("userid", user.getUserID());
		jsonObject.addProperty("firstName", user.getFirstName());
		jsonObject.addProperty("lastName", user.getLastName());
		jsonObject.addProperty("token", user.getToken());
		return jsonObject;
	}
	
//	public JsonElement convertToJsonElement(final List<Message> messages){
//		JsonArray jsonArray = new JsonArray();
//		for(Message message : messages){
//			jsonArray.add(convertToJsonElement(message));
//		}
//		return jsonArray;
//	}

}
