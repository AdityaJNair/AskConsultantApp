package com.askconsultant.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.askconsultant.dao.Constants;
import com.askconsultant.dao.ConversationDAO;
import com.askconsultant.dao.MessageDAO;
import com.askconsultant.model.Conversation;
import com.askconsultant.service.ConversationService;
import com.askconsultant.service.dto.ConversationAndMessages;

/**
 * This class provides implementation for storing and retrieving conversations
 */
public class ConversationServiceImpl implements ConversationService {

	@Inject
	ConversationDAO conversationDAO;
	
	@Inject
	MessageDAO messageDAO;

	/* (non-Javadoc)
	 * @see com.askconsultant.service.ConversationService#addConversation(com.askconsultant.model.Conversation)
	 */
	@Override
	public Conversation addConversation(Conversation conversation) {
		conversation.setCreatedatetime(Timestamp.valueOf(LocalDateTime.now()));
		conversation.setStatus(Constants.CONVERSATION_STATUS_ACTIVE);
		return conversationDAO.addConversation(conversation);
	}

	/* (non-Javadoc)
	 * @see com.askconsultant.service.ConversationService#archiveConversation(long, java.lang.String)
	 */
	@Override
	public void archiveConversation(long conversationID, String userid) {
		conversationDAO.archiveConversation(conversationID, userid);
		
	}

	/* (non-Javadoc)
	 * @see com.askconsultant.service.ConversationService#listAllConversations()
	 */
	@Override
	public List<Conversation> listAllConversations() {
		return conversationDAO.listAllConversations();
	}

	/* (non-Javadoc)
	 * @see com.askconsultant.service.ConversationService#listActiveConversations()
	 */
	@Override
	public List<Conversation> listActiveConversations() {
		return conversationDAO.listAllActiveConversations();
	}

	/* (non-Javadoc)
	 * @see com.askconsultant.service.ConversationService#listActiveConversationsWithMessages()
	 */
	@Override
	public List<ConversationAndMessages> listActiveConversationsWithMessages() {
		List<ConversationAndMessages> conversationAndMessages = new ArrayList<ConversationAndMessages>();
		List<Conversation> activeConversations = conversationDAO.listAllActiveConversations();
		ConversationAndMessages conversationAndMessagesObj;
		for(Conversation conversation : activeConversations) {
			conversationAndMessagesObj = new ConversationAndMessages();
			conversationAndMessagesObj.setConversation(conversation);
			conversationAndMessagesObj.setMessage(messageDAO.listMessagesByConversationID(conversation.getId()));
		}
		return conversationAndMessages;
	}

	/* (non-Javadoc)
	 * @see com.askconsultant.service.ConversationService#listActiveConversationsWithMessagesForUser(java.lang.String)
	 */
	@Override
	public List<ConversationAndMessages> listActiveConversationsWithMessagesForUser(String userid) {
		List<ConversationAndMessages> conversationAndMessages = new ArrayList<ConversationAndMessages>();
		List<Conversation> activeConversations = conversationDAO.listActiveConversationsByUser(userid);
		ConversationAndMessages conversationAndMessagesObj;
		for(Conversation conversation : activeConversations) {
			conversationAndMessagesObj = new ConversationAndMessages();
			conversationAndMessagesObj.setConversation(conversation);
			conversationAndMessagesObj.setMessage(messageDAO.listMessagesByConversationID(conversation.getId()));
		}
		return conversationAndMessages;
	}

	/* (non-Javadoc)
	 * @see com.askconsultant.service.ConversationService#getConversation(long)
	 */
	@Override
	public Conversation getConversation(long conversationID) {
		return conversationDAO.getConversationByID(conversationID);
	}

	/* (non-Javadoc)
	 * @see com.askconsultant.service.ConversationService#listAllConversationsForUser(java.lang.String)
	 */
	@Override
	public List<Conversation> listAllConversationsForUser(String userid) {
		return conversationDAO.listActiveConversationsByUser(userid);
	}
	
}
