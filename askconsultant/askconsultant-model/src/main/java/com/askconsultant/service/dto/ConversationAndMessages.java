package com.askconsultant.service.dto;
import java.util.List;

import com.askconsultant.model.Message;

public class ConversationAndMessages {

	private com.askconsultant.model.Conversation conversation;
	private List<Message> message;
	
	public com.askconsultant.model.Conversation getConversation() {
		return conversation;
	}
	public void setConversation(com.askconsultant.model.Conversation conversation) {
		this.conversation = conversation;
	}
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	
}
