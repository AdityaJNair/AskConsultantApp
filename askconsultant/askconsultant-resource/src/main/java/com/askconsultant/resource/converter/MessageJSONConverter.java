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
		message.setMessage(JsonReader.getStringOrNull(jsonObject, "message"));
		return message;
	}
	
	public JsonElement convertToJsonElement(final Message message){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", message.getId());
		jsonObject.addProperty("message", message.getMessage());
		jsonObject.addProperty("user", message.getSender());
		jsonObject.addProperty("datetime", message.getCreateDateTime().toString());
		jsonObject.addProperty("conversationid", message.getConversation());
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
