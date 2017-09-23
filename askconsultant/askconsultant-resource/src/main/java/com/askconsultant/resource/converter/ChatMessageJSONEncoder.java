package com.askconsultant.resource.converter;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.askconsultant.interactive.dto.ChatMessage;
import com.google.gson.JsonObject;

public class ChatMessageJSONEncoder implements Encoder.Text<ChatMessage>{

	@Override
	public void init(EndpointConfig config) {
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public String encode(ChatMessage object) throws EncodeException {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("message", object.getMessage());
		jsonObject.addProperty("sentbydisplayname", object.getDisplayName());
		jsonObject.addProperty("sentbyuserid", object.getUserid());
		jsonObject.addProperty("conversationid", object.getConversationid());
		jsonObject.addProperty("sentat", object.getSentAt());
		return jsonObject.toString();
	}

}
