package com.askconsultant.resource.converter;

import java.text.SimpleDateFormat;

import javax.enterprise.context.ApplicationScoped;

import com.askconsultant.common.json.JsonReader;
import com.askconsultant.model.RegistrationDetails;
import com.askconsultant.service.dto.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@ApplicationScoped
public class RegistrationJSONConverter {

	public User convert(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final User user = new User();
		user.setFirstName(JsonReader.getStringOrNull(jsonObject, "firstname"));
		user.setLastName(JsonReader.getStringOrNull(jsonObject, "lastname"));
		user.setPreferredName(JsonReader.getStringOrNull(jsonObject, "prefferedname"));
		user.setEmail(JsonReader.getStringOrNull(jsonObject, "email"));
		user.setDateOfBirth(new SimpleDateFormat("MM/dd/yyyy").parse(JsonReader.getStringOrNull(jsonObject, "dob")));
		user.setOccupation(JsonReader.getStringOrNull(jsonObject, "prefferedname"));
		user.setGender(JsonReader.getStringOrNull(jsonObject, "gender"));
		user.setIndustry(JsonReader.getStringOrNull(jsonObject, "industry"));
		user.setInterest(JsonReader.getStringOrNull(jsonObject, "interest"));
		user.setSource(JsonReader.getStringOrNull(jsonObject, "source"));
		return user;
	}
	
//	public JsonElement convertToJsonElement(final com.askconsultant.service.dto.User user){
//		final JsonObject jsonObject = new JsonObject();
//		jsonObject.addProperty("userid", user.getUserID());
//		jsonObject.addProperty("firstName", user.getFirstName());
//		jsonObject.addProperty("lastName", user.getLastName());
//		jsonObject.addProperty("token", user.getToken());
//		return jsonObject;
//	}
	
//	public JsonElement convertToJsonElement(final List<Message> messages){
//		JsonArray jsonArray = new JsonArray();
//		for(Message message : messages){
//			jsonArray.add(convertToJsonElement(message));
//		}
//		return jsonArray;
//	}

}
