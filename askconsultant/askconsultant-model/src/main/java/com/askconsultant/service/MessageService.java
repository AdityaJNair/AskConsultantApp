package com.askconsultant.service;

import java.util.List;

import javax.ejb.Local;

import com.askconsultant.model.Message;

@Local
public interface MessageService {

	public Message addMessage(Message message);
	
	public List<Message> listMessagesForConversation(long conversationID);
	
	public List<Message> listRepliesForMessage(long conversationId, long messageid );
	
	public Message getMessage(long messageID);
	
}
