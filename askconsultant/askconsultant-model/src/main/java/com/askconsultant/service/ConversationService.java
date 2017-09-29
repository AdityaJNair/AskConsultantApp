package com.askconsultant.service;

import java.util.List;

import javax.ejb.Local;

import com.askconsultant.model.Conversation;
import com.askconsultant.service.dto.ConversationAndMessages;
import com.askconsultant.service.dto.ConversationWithLatestMessageDTO;

/**
 * Interface providing methods to send and receive conversations
 *
 */
@Local
public interface ConversationService {

	/**
	 * Creates a conversation object 
	 * @param conversation
	 * @return
	 */
	public Conversation addConversation(Conversation conversation);
	
	/**
	 * Retrieves a conversation based on conversation id
	 * @param conversationID
	 * @return
	 */
	public Conversation getConversation(long conversationID);
	
	/**
	 * Archives a conversation based on the id
	 * @param conversationID
	 * @param userid
	 */
	public void archiveConversation(long conversationID, String userid);
	
	/**
	 * Lists all conversations
	 * @return
	 */
	public List<ConversationWithLatestMessageDTO> listAllConversations();
	
	/**
	 * Lists all conversation created by the user
	 * @param userid
	 * @return
	 */
	public List<ConversationWithLatestMessageDTO> listAllConversationsForUser(String userid);
	
	/**
	 * Lists all active conversation
	 * @return
	 */
	public List<Conversation> listActiveConversations();
	
	/**
	 * Lists all active conversations with messages
	 * @return
	 */
	public List<ConversationAndMessages> listActiveConversationsWithMessages();
	
	
	/**
	 * Lists all active conversations with messages for a user
	 * @param userid
	 * @return
	 */
	public List<ConversationAndMessages> listActiveConversationsWithMessagesForUser(String userid);

	/**
	 * @param userid
	 * @return
	 */
	public List<ConversationWithLatestMessageDTO> listActiveConversations(String userid);
	
}

