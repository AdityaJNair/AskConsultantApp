package com.askconsultant.resource.converter;

import java.text.SimpleDateFormat;

import javax.enterprise.context.ApplicationScoped;

import com.askconsultant.common.json.JsonReader;
import com.askconsultant.model.RegistrationDetails;
import com.askconsultant.service.dto.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Contains methods to convert to and from JSON to User object
 *
 */
@ApplicationScoped
public class RegistrationJSONConverter {

	public User convert(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final User user = new User();
		user.setFirstName(JsonReader.getStringOrNull(jsonObject, "firstname"));
		user.setLastName(JsonReader.getStringOrNull(jsonObject, "lastname"));
		user.setPreferredName(JsonReader.getStringOrNull(jsonObject, "preferedname"));
		user.setEmail(JsonReader.getStringOrNull(jsonObject, "email"));
		user.setUserID(JsonReader.getStringOrNull(jsonObject, "email"));
		user.setDateOfBirth(new SimpleDateFormat("DD/MM/yyyy").parse(JsonReader.getStringOrNull(jsonObject, "dob")));
		user.setOccupation(JsonReader.getStringOrNull(jsonObject, "occupation"));
		user.setGender(JsonReader.getStringOrNull(jsonObject, "gender"));
		user.setIndustry(JsonReader.getStringOrNull(jsonObject, "industry"));
		user.setInterest(JsonReader.getStringOrNull(jsonObject, "interest"));
		user.setSource(JsonReader.getStringOrNull(jsonObject, "source"));
		user.setPassword(JsonReader.getStringOrNull(jsonObject, "password"));
		return user;
	}
	
	public JsonElement convertToJsonElement(com.askconsultant.model.User user){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("userid", user.getUserid());
		jsonObject.addProperty("password", user.getPassword());
		jsonObject.addProperty("industry", user.getIndustry());
		jsonObject.addProperty("interest", user.getInterest());
		jsonObject.addProperty("source", user.getSource());
		jsonObject.addProperty("status", user.getStatus());
		return jsonObject;
	}
	
	public JsonElement convertToJsonElement(RegistrationDetails details){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("firstName", details.getFirstName());
		jsonObject.addProperty("lastName", details.getLastName());
		jsonObject.addProperty("preferedname", details.getPreferredName());
		jsonObject.addProperty("email", details.getEmail());
		jsonObject.addProperty("dob", details.getDateOfBirth().toString());
		jsonObject.addProperty("occupation", details.getOccupation());
		jsonObject.addProperty("gender", details.getGender());
		
		return jsonObject;
	}

}
