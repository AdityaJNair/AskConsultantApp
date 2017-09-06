package com.askconsultant.service;

import java.util.List;

import javax.ejb.Local;

import com.askconsultant.model.Conversation;
import com.askconsultant.service.dto.ConversationAndMessages;

@Local
public interface ConversationService {

	public Conversation addConversation(Conversation conversation);
	
	public Conversation getConversation(long conversationID);
	
	public void archiveConversation(long conversationID, String userid);
	
	public List<Conversation> listAllConversations();
	
	public List<Conversation> listAllConversationsForUser(String userid);
	
	public List<Conversation> listActiveConversations();
	
	public List<ConversationAndMessages> listActiveConversationsWithMessages();
	
	public List<ConversationAndMessages> listActiveConversationsWithMessagesForUser(String userid);
	
}

