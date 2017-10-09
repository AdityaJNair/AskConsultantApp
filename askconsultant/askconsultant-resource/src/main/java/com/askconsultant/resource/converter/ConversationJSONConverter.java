package com.askconsultant.resource.converter;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.askconsultant.common.DateTimeHelper;
import com.askconsultant.common.json.JsonReader;
import com.askconsultant.model.Conversation;
import com.askconsultant.model.Message;
import com.askconsultant.service.dto.ConversationWithLatestMessageDTO;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Contains methods to convert to and from JSON to Conversation object
 *
 */
@ApplicationScoped
public class ConversationJSONConverter {

	/**
	 * Creates a ConversationObject from input json
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public Conversation convert(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final Conversation conversation = new Conversation();
		conversation.setName(JsonReader.getStringOrNull(jsonObject, "question"));
		conversation.setContent(JsonReader.getStringOrNull(jsonObject, "firstmessage"));
		conversation.setCategory(JsonReader.getStringOrNull(jsonObject, "topic"));
		conversation.setSubCategory(JsonReader.getStringOrNull(jsonObject, "subtopic"));
		return conversation;
	}
	
	/**
	 * Creates  JSON Object from a Conversation object
	 * @param conversation
	 * @return
	 */
	public JsonElement convertToJsonElement(final ConversationWithLatestMessageDTO conversationAndLatestMessage){
		final JsonObject jsonObject = new JsonObject();
		Conversation conversation = conversationAndLatestMessage.getConversation();
		Message message = conversationAndLatestMessage.getMessage();
		conversationConverter(jsonObject, conversation);
		messageConverter(jsonObject, message);
		return jsonObject;
	}

	private void messageConverter(final JsonObject jsonObject, Message message) {
		jsonObject.addProperty("latestmessage", message.getMessage());
		jsonObject.addProperty("latestmessagesentby", message.getSender());
		jsonObject.addProperty("latestmessagesentat", DateTimeHelper.dateTimeFormatter(message.getCreateDateTime()));
	}
	
	public JsonElement convertToJsonElement(final Conversation conversation){
		final JsonObject jsonObject = new JsonObject();
		return this.conversationConverter(jsonObject, conversation);
	}

	private JsonObject conversationConverter(final JsonObject jsonObject, Conversation conversation) {
		jsonObject.addProperty("id", conversation.getId());
		jsonObject.addProperty("question", conversation.getName());
		jsonObject.addProperty("owner", conversation.getOwner());
		jsonObject.addProperty("lastupdate", DateTimeHelper.dateTimeFormatter(conversation.getCreatedatetime()));
		jsonObject.addProperty("category", conversation.getCategory());
		jsonObject.addProperty("subcategory", conversation.getSubCategory());
		return jsonObject;
	}
	
	/**
	 * Converts a list of Conversation objects to JSON Array
	 * @param conversationList
	 * @return
	 */
	public JsonElement convertToJsonElement(final List<ConversationWithLatestMessageDTO> conversationList){
		JsonArray jsonArray = new JsonArray();
		for(ConversationWithLatestMessageDTO conversation : conversationList){
			jsonArray.add(convertToJsonElement(conversation));
		}
		return jsonArray;
	}
}
