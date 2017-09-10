package com.askconsultant.common;

import org.junit.Ignore;

import com.askconsultant.model.Conversation;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Ignore
public class JSONElementHelper {

	public static JsonElement returnConversationJSONObjectValues(long id, String name, String owner, String dateTime, String category) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", id);
		jsonObject.addProperty("name", name);
		jsonObject.addProperty("owner", owner);
		jsonObject.addProperty("createddatetime", dateTime);
		jsonObject.addProperty("category", category);
		return jsonObject;
	}
	
	public static JsonElement returnMessageJSONObjectValues(long id, String message, String owner, String dateTime, String conversationid) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", id);
		jsonObject.addProperty("message", message);
		jsonObject.addProperty("user", owner);
		jsonObject.addProperty("datetime", dateTime);
		jsonObject.addProperty("conversationid",conversationid);
		return jsonObject;
	}
	
	
	public static JsonElement returnGenericOpFailureJSONObjectValues(String message) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("mesage", message);
		return jsonObject;
	}
	
	public static JsonElement returnConversationJSONArray() {
		JsonArray jsonArray = new JsonArray();
		jsonArray.add(returnConversationJSONObjectValues(1,"name","owner","datetime","category"));
		jsonArray.add(returnConversationJSONObjectValues(2,"name","owner","datetime","category"));
		jsonArray.add(returnConversationJSONObjectValues(3,"name","owner","datetime","category"));
		jsonArray.add(returnConversationJSONObjectValues(4,"name","owner","datetime","category"));
		return jsonArray;
	}
	
	public static JsonElement returnMessageJSONArray() {
		JsonArray jsonArray = new JsonArray();
		jsonArray.add(returnMessageJSONObjectValues(1l, "mesasge", "owner", "datetime", "2"));
		jsonArray.add(returnMessageJSONObjectValues(1l, "mesasge", "owner", "datetime", "2"));
		jsonArray.add(returnMessageJSONObjectValues(1l, "mesasge", "owner", "datetime", "2"));
		jsonArray.add(returnMessageJSONObjectValues(1l, "mesasge", "owner", "datetime", "2"));
		jsonArray.add(returnMessageJSONObjectValues(1l, "mesasge", "owner", "datetime", "2"));
		return jsonArray;
	}
	
	
}
