package com.askconsultant.resource.converter;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.askconsultant.common.DateTimeHelper;
import com.askconsultant.common.json.JsonReader;
import com.askconsultant.model.Conversation;
import com.askconsultant.model.Message;
import com.askconsultant.service.ConversationService;
import com.askconsultant.service.RegistrationService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Contains methods for Conversion to and from JSON to Message object
 *
 */
@ApplicationScoped
public class MessageJSONConverter {

	@Inject
	RegistrationService registrationService;
	
	@Inject
	ConversationService conversationService;
	
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu");

	/**
	 * Converts a json string to a Message Object
	 * 
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
	 * 
	 * @param message
	 * @return
	 */
	public JsonElement convertToJsonElement(final Message message) {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", message.getId());
		jsonObject.addProperty("message", message.getMessage());
		jsonObject.addProperty("user", registrationService.getDisplayOrPreferredName(message.getSender()));
		jsonObject.addProperty("sentbyuserid",message.getSender());
		jsonObject.addProperty("conversationid", message.getConversation());
		jsonObject.addProperty("sentat", DateTimeHelper.dateTimeFormatter(message.getCreateDateTime()));
		jsonObject.addProperty("conversationid", message.getConversation());
		Conversation conversation = conversationService.getConversation(message.getConversation());
		//set the sendersent to be true if the message is sent by a a user who owns the conversation
		if(conversation.getOwner().equalsIgnoreCase(message.getSender())) {
			jsonObject.addProperty("sendersent", "true");
		}else {
			jsonObject.addProperty("sendersent", "false");
		}
		return jsonObject;
	}

	/**
	 * Converts a list of Message objects to JSON array
	 * 
	 * @param messages
	 * @return
	 */
	public JsonElement convertToJsonElement(final List<Message> messages) {
		JsonArray jsonArray = new JsonArray();
		for (Message message : messages) {
			jsonArray.add(convertToJsonElement(message));
		}
		return jsonArray;
	}

}
