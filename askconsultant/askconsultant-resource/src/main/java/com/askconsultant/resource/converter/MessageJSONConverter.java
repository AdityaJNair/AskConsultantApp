package com.askconsultant.resource.converter;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.askconsultant.common.json.JsonReader;
import com.askconsultant.model.Message;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Contains methods for Conversion to and from JSON to Message object
 *
 */
@ApplicationScoped
public class MessageJSONConverter {

	/**
	 * Converts a json string to a Message Object
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public Message convert(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final Message message = new Message();
		message.setMessage(JsonReader.getStringOrNull(jsonObject, "message"));
		return message;
	}
	
	/**
	 * Converts a Message object to JSON object
	 * @param message
	 * @return
	 */
	public JsonElement convertToJsonElement(final Message message){
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", message.getId());
		jsonObject.addProperty("message", message.getMessage());
		jsonObject.addProperty("user", message.getSender());
		jsonObject.addProperty("datetime", message.getCreateDateTime().toString());
		jsonObject.addProperty("conversationid", message.getConversation());
		return jsonObject;
	}
	
	/**
	 * Converts a list of Message objects to JSON array
	 * @param messages
	 * @return
	 */
	public JsonElement convertToJsonElement(final List<Message> messages){
		JsonArray jsonArray = new JsonArray();
		for(Message message : messages){
			jsonArray.add(convertToJsonElement(message));
		}
		return jsonArray;
	}

}
