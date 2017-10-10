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

	private static final String TOKEN = "token";
	private static final String PREFERREDNAME = "preferredname";
	private static final String IS_EMPLOYEE = "isEmployee";
	private static final String PASSWORD = "password";
	private static final String USERID = "userid";

	/**
	 * Method to convert json request to User object
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public User convert(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final User user = new User();
		user.setUserID(JsonReader.getStringOrNull(jsonObject, USERID));
		user.setPassword(JsonReader.getStringOrNull(jsonObject, PASSWORD));
		user.setEmployee((Boolean.parseBoolean(JsonReader.getStringOrNull(jsonObject, IS_EMPLOYEE))));
		return user;
	}
	
	/**
	 * Converts the user object to JSONElement
	 * @param user
	 * @return
	 */
	public JsonElement convertToJsonElement(final com.askconsultant.service.dto.User user){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(USERID, user.getUserID());
		jsonObject.addProperty(PREFERREDNAME, user.getPreferredName());
		jsonObject.addProperty(TOKEN, user.getToken());
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
