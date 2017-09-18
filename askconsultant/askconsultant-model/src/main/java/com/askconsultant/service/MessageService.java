package com.askconsultant.service;

import java.util.List;

import javax.ejb.Local;

import com.askconsultant.model.Message;

/**
 * Interface containing methods to send and receive messages
 */
@Local
public interface MessageService {

	/**
	 * Creates a message
	 * @param message
	 * @return
	 */
	public Message addMessage(Message message);
	
	/**
	 * Lists all messages for a conversation
	 * @param conversationID
	 * @return
	 */
	public List<Message> listMessagesForConversation(long conversationID);
	
	/**
	 * Lists all replies for a given message
	 * @param conversationId
	 * @param messageid
	 * @return
	 */
	public List<Message> listRepliesForMessage(long conversationId, long messageid );
	
	/**
	 * Retrieves message details  for a message id
	 * @param messageID
	 * @return
	 */
	public Message getMessage(long messageID);
	
}
