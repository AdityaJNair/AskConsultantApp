package com.askconsultant.resource.converter;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.askconsultant.service.dto.ChatMessage;
import com.google.gson.JsonObject;

/**
 * Encoder class for interactive chat service
 *
 */
public class ChatMessageJSONEncoder implements Encoder.Text<ChatMessage>{

	private static final String FALSE = "false";
	private static final String TRUE = "true";
	private static final String SENDERSENT = "sendersent";
	private static final String SENTAT = "sentat";
	private static final String CONVERSATIONID = "conversationid";
	private static final String SENTBYUSERID = "sentbyuserid";
	private static final String SENTBYDISPLAYNAME = "sentbydisplayname";
	private static final String MESSAGE = "message";
	private static final String ID = "id";

	@Override
	public void init(EndpointConfig config) {
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public String encode(ChatMessage object) throws EncodeException {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty(ID, object.getId());
		jsonObject.addProperty(MESSAGE, object.getMessage());
		jsonObject.addProperty(SENTBYDISPLAYNAME, object.getDisplayName());
		jsonObject.addProperty(SENTBYUSERID, object.getUserid());
		jsonObject.addProperty(CONVERSATIONID, object.getConversationid());
		jsonObject.addProperty(SENTAT, object.getSentAt());
		if(object.isSenderSent()) {
			jsonObject.addProperty(SENDERSENT, TRUE);
		}else {
			jsonObject.addProperty(SENDERSENT, FALSE);
		}
		return jsonObject.toString();
	}

}
