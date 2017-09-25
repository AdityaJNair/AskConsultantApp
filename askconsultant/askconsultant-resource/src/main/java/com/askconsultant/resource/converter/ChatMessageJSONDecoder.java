package com.askconsultant.resource.converter;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.askconsultant.common.json.JsonReader;
import com.askconsultant.interactive.dto.ChatMessage;
import com.google.gson.JsonObject;

public class ChatMessageJSONDecoder implements Decoder.Text<ChatMessage> {

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
			chatMessage.setConversationid(Long.parseLong(JsonReader.getStringOrNull(jsonObject, "conversationid")));
			chatMessage.setMessage(JsonReader.getStringOrNull(jsonObject, "message"));
			chatMessage.setUserid(JsonReader.getStringOrNull(jsonObject, "userid"));
			//set the current date time
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
