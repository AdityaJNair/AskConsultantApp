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

	private static final String LAST_NAME = "lastName";
	private static final String FIRST_NAME = "firstName";
	private static final String STATUS = "status";
	private static final String INTEREST = "interest";
	private static final String USERID = "userid";
	private static final String PRIMARY_SUB_TOPIC = "primarySubTopic";
	private static final String PRIMARY_TOPIC = "primaryTopic";
	private static final String ROLE = "role";
	private static final String NAME = "name";
	private static final String PASSWORD = "password";
	private static final String SOURCE = "source";
	private static final String INDUSTRY = "industry";
	private static final String GENDER = "gender";
	private static final String OCCUPATION = "occupation";
	private static final String DOB = "dob";
	private static final String DD_MM_YYYY = "DD/MM/yyyy";
	private static final String EMAIL = "email";
	private static final String PREFEREDNAME = "preferedname";
	private static final String LASTNAME = "lastname";
	private static final String FIRSTNAME = "firstname";

	/**
	 * Converts the json request to User object
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public User convert(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final User user = new User();
		user.setFirstName(JsonReader.getStringOrNull(jsonObject, FIRSTNAME));
		user.setLastName(JsonReader.getStringOrNull(jsonObject, LASTNAME));
		user.setPreferredName(JsonReader.getStringOrNull(jsonObject, PREFEREDNAME));
		user.setEmail(JsonReader.getStringOrNull(jsonObject, EMAIL));
		user.setUserID(JsonReader.getStringOrNull(jsonObject, EMAIL));
		user.setDateOfBirth(new SimpleDateFormat(DD_MM_YYYY).parse(JsonReader.getStringOrNull(jsonObject, DOB)));
		user.setOccupation(JsonReader.getStringOrNull(jsonObject, OCCUPATION));
		user.setGender(JsonReader.getStringOrNull(jsonObject, GENDER));
		user.setIndustry(JsonReader.getStringOrNull(jsonObject, INDUSTRY));
		user.setInterest(JsonReader.getStringOrNull(jsonObject, "	"));
		user.setSource(JsonReader.getStringOrNull(jsonObject, SOURCE));
		user.setPassword(JsonReader.getStringOrNull(jsonObject, PASSWORD));
		return user;
	}
	
	/**
	 * Converts the JSON request to employee registration object
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public User convertEmployeeRegistrationJSON(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final User user = new User();
		user.setUserID(JsonReader.getStringOrNull(jsonObject, EMAIL));
		user.setPassword(JsonReader.getStringOrNull(jsonObject, PASSWORD));
		user.setName(JsonReader.getStringOrNull(jsonObject, NAME));
		user.setRole(JsonReader.getStringOrNull(jsonObject, ROLE));
		user.setPrimaryTopic(JsonReader.getStringOrNull(jsonObject, PRIMARY_TOPIC));
		user.setPrimarySubTopic(JsonReader.getStringOrNull(jsonObject, PRIMARY_SUB_TOPIC));
		return user;
	}
	
	/**
	 * Converts the User object to JSON object
	 * @param user
	 * @return
	 */
	public JsonElement convertToJsonElement(com.askconsultant.model.User user){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(USERID, user.getUserid());
		jsonObject.addProperty(PASSWORD, user.getPassword());
		jsonObject.addProperty(INDUSTRY, user.getIndustry());
		jsonObject.addProperty(INTEREST, user.getInterest());
		jsonObject.addProperty(SOURCE, user.getSource());
		jsonObject.addProperty(STATUS, user.getStatus());
		return jsonObject;
	}
	
	/**
	 * Converts the user Registration Object to json
	 * @param details
	 * @return
	 */
	public JsonElement convertToJsonElement(RegistrationDetails details){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(FIRST_NAME, details.getFirstName());
		jsonObject.addProperty(LAST_NAME, details.getLastName());
		jsonObject.addProperty(PREFEREDNAME, details.getPreferredName());
		jsonObject.addProperty(EMAIL, details.getEmail());
		jsonObject.addProperty(DOB, details.getDateOfBirth().toString());
		jsonObject.addProperty(OCCUPATION, details.getOccupation());
		jsonObject.addProperty(GENDER, details.getGender());
		return jsonObject;
	}

}
