package com.askconsultant.resource.converter;

import javax.enterprise.context.ApplicationScoped;

import com.askconsultant.common.json.JsonReader;
import com.askconsultant.service.dto.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@ApplicationScoped
public class SessionJSONConverter {

	public User convert(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final User user = new User();
		user.setUserID(JsonReader.getStringOrNull(jsonObject, "userid"));
		user.setPassword(JsonReader.getStringOrNull(jsonObject, "password"));
		return user;
	}
	
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
