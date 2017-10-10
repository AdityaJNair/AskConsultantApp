package com.askconsultant.resource.converter;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.askconsultant.common.json.JsonReader;
import com.askconsultant.service.dto.ChatMessage;
import com.google.gson.JsonObject;

/**
 * Decoder class for the websocket functionality
 *
 */
public class ChatMessageJSONDecoder implements Decoder.Text<ChatMessage> {

	private static final String USERID = "userid";
	private static final String MESSAGE = "message";
	private static final String CONVERSATIONID = "conversationid";

	@Override
	public void init(EndpointConfig config) {

	}

	@Override
	public void destroy() {

	}

	@Override
	public ChatMessage decode(String json) throws DecodeException {
		final ChatMessage chatMessage = new ChatMessage();
		try {
			JsonObject jsonObject = JsonReader.readAsJsonObject(json);
			chatMessage.setConversationid(Long.parseLong(JsonReader.getStringOrNull(jsonObject, CONVERSATIONID)));
			chatMessage.setMessage(JsonReader.getStringOrNull(jsonObject, MESSAGE));
			chatMessage.setUserid(JsonReader.getStringOrNull(jsonObject, USERID));
		} catch (Exception e) {
			e.printStackTrace();
			return chatMessage;
		}
		return chatMessage;
	}

	@Override
	public boolean willDecode(String s) {
		return true;
	}

}
