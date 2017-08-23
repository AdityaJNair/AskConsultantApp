package com.askconsultant.resource.converter;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.askconsultant.common.json.JsonReader;
import com.askconsultant.model.Message;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@ApplicationScoped
public class MessageJSONConverter {

	public Message convert(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final Message message = new Message();
		message.setChatName(JsonReader.getStringOrNull(jsonObject, "chatName"));
		message.setMessage(JsonReader.getStringOrNull(jsonObject, "message"));
		message.setUsername(JsonReader.getStringOrNull(jsonObject, "username"));
		return message;
	}
	
	public JsonElement convertToJsonElement(final Message message){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", message.getId());
		jsonObject.addProperty("message", message.getMessage());
		jsonObject.addProperty("username", message.getUsername());
		jsonObject.addProperty("chatname", message.getChatName());
		return jsonObject;
	}
	
	public JsonElement convertToJsonElement(final List<Message> messages){
		JsonArray jsonArray = new JsonArray();
		for(Message message : messages){
			jsonArray.add(convertToJsonElement(message));
		}
		return jsonArray;
	}

}
