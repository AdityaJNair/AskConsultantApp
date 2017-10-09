package com.askconsultant.service.impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.websocket.Session;

import com.askconsultant.model.Conversation;
import com.askconsultant.service.ChatInteractionService;
import com.askconsultant.service.ChatSessionService;
import com.askconsultant.service.ConversationService;
import com.askconsultant.service.RegistrationService;
import com.askconsultant.service.dto.ChatMessage;

/**
 *
 */
@Stateless
public class ChatInteractionServiceImpl implements ChatInteractionService {

	@Inject 
	ConversationService conversationService;
	
	@Inject
	RegistrationService registrationService;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.askconsultant.service.ChatInteractionService#sendRepliesToListeners(com.
	 * askconsultant.service.ChatSessionService, com.askconsultant.model.Message)
	 */
	@Override
	public void sendRepliesToListeners(ChatSessionService chatsessionService, long conversationid,
			ChatMessage message) {
		Set<Session> activeSessions = chatsessionService.getAllSessionsForConversationID(conversationid);
		if (!activeSessions.isEmpty()) {
			for (Session session : activeSessions) {
				session.getAsyncRemote().sendObject(message);
			}
		}

	}

	@Override
	public void setProperties(long conversationid, ChatMessage message) {
		Conversation conversation = conversationService.getConversation(conversationid);
		String displayOrPreferredName = registrationService.getDisplayOrPreferredName(message.getUserid());
		message.setDisplayName(displayOrPreferredName);
		if(conversation.getOwner().equalsIgnoreCase(message.getUserid())) {
			message.setSenderSent(true);
		}else {
			message.setSenderSent(false);
		}
		
	}


}
