package com.askconsultant.service.impl;

import java.util.Set;

import javax.ejb.Stateless;
import javax.websocket.Session;

import com.askconsultant.service.ChatInteractionService;
import com.askconsultant.service.ChatSessionService;
import com.askconsultant.service.dto.ChatMessage;

/**
 *
 */
@Stateless
public class ChatInteractionServiceImpl implements ChatInteractionService {

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

}
