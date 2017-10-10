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

	private static final String SUBCATEGORY = "subcategory";
	private static final String CATEGORY = "category";
	private static final String LASTUPDATE = "lastupdate";
	private static final String OWNER = "owner";
	private static final String ID = "id";
	private static final String LATESTMESSAGESENTAT = "latestmessagesentat";
	private static final String LATESTMESSAGESENTBY = "latestmessagesentby";
	private static final String LATESTMESSAGE = "latestmessage";
	private static final String SUBTOPIC = "subtopic";
	private static final String TOPIC = "topic";
	private static final String FIRSTMESSAGE = "firstmessage";
	private static final String QUESTION = "question";

	/**
	 * Creates a ConversationObject from input json
	 * @param json
	 * @return
	 * @throws Exception
	 */
	public Conversation convert(String json) throws Exception {
		JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		final Conversation conversation = new Conversation();
		conversation.setName(JsonReader.getStringOrNull(jsonObject, QUESTION));
		conversation.setContent(JsonReader.getStringOrNull(jsonObject, FIRSTMESSAGE));
		conversation.setCategory(JsonReader.getStringOrNull(jsonObject, TOPIC));
		conversation.setSubCategory(JsonReader.getStringOrNull(jsonObject, SUBTOPIC));
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
		jsonObject.addProperty(LATESTMESSAGE, message.getMessage());
		jsonObject.addProperty(LATESTMESSAGESENTBY, message.getSender());
		jsonObject.addProperty(LATESTMESSAGESENTAT, DateTimeHelper.dateTimeFormatter(message.getCreateDateTime()));
	}
	
	public JsonElement convertToJsonElement(final Conversation conversation){
		final JsonObject jsonObject = new JsonObject();
		return this.conversationConverter(jsonObject, conversation);
	}

	private JsonObject conversationConverter(final JsonObject jsonObject, Conversation conversation) {
		jsonObject.addProperty(ID, conversation.getId());
		jsonObject.addProperty(QUESTION, conversation.getName());
		jsonObject.addProperty(OWNER, conversation.getOwner());
		jsonObject.addProperty(LASTUPDATE, DateTimeHelper.dateTimeFormatter(conversation.getCreatedatetime()));
		jsonObject.addProperty(CATEGORY, conversation.getCategory());
		jsonObject.addProperty(SUBCATEGORY, conversation.getSubCategory());
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
