package com.askconsultant.service.dto;

import com.askconsultant.model.Conversation;
import com.askconsultant.model.Message;

public class ConversationWithLatestMessageDTO {

	private Conversation conversation =  new Conversation();
	private Message message = new Message();
	
	public Conversation getConversation() {
		return conversation;
	}
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
}
