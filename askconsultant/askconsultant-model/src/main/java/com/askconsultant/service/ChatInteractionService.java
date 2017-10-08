package com.askconsultant.service;

import javax.ejb.Local;

import com.askconsultant.service.dto.ChatMessage;

/**
 * Contains methods to provide manage sending replies to all listeners
 */
@Local
public interface ChatInteractionService {

	/**
	 * This method will send replies to all the listeners of the particular conversation
	 * @param chatsessionService
	 * @param conversationid
	 * @param message
	 */
	public void sendRepliesToListeners(ChatSessionService chatsessionService, long conversationid, ChatMessage message);
	
	/**
	 * This method will set the properties
	 * @param chatsessionService
	 * @param conversationid
	 * @param message
	 */
	public void setProperties(long conversationid, ChatMessage message);
	
}
