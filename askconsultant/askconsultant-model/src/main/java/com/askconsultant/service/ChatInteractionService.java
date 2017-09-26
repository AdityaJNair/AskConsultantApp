package com.askconsultant.service;

import javax.ejb.Local;

import com.askconsultant.service.dto.ChatMessage;

/**
 *
 */
@Local
public interface ChatInteractionService {

	/**
	 * @param chatsessionService
	 * @param conversationid
	 * @param message
	 */
	public void sendRepliesToListeners(ChatSessionService chatsessionService, long conversationid, ChatMessage message);
	
}
