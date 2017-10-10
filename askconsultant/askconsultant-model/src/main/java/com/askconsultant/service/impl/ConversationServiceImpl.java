package com.askconsultant.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.askconsultant.dao.Constants;
import com.askconsultant.dao.ConversationDAO;
import com.askconsultant.dao.MessageDAO;
import com.askconsultant.dao.RegistrationDAO;
import com.askconsultant.model.Conversation;
import com.askconsultant.model.Message;
import com.askconsultant.service.AuthenticationService;
import com.askconsultant.service.ConversationService;
import com.askconsultant.service.EmployeeService;
import com.askconsultant.service.RegistrationService;
import com.askconsultant.service.dto.ConversationAndMessages;
import com.askconsultant.service.dto.ConversationWithLatestMessageDTO;

/**
 * This class provides implementation for storing and retrieving conversations
 */
public class ConversationServiceImpl implements ConversationService {

	@Inject
	ConversationDAO conversationDAO;

	@Inject
	MessageDAO messageDAO;

	@Inject
	RegistrationDAO registrationDAO;

	@Inject
	AuthenticationService authService;

	@Inject
	RegistrationService registrationService;

	@Inject
	EmployeeService employeeService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.askconsultant.service.ConversationService#addConversation(com.
	 * askconsultant.model.Conversation)
	 */
	@Override
	public Conversation addConversation(Conversation conversation) {
		conversation.setCreatedatetime(Timestamp.valueOf(LocalDateTime.now()));
		conversation.setStatus(Constants.CONVERSATION_STATUS_ACTIVE);
		conversation.setName(conversation.getName());
		conversation.setCategory(conversation.getCategory());
		conversation.setContent(conversation.getContent());
		conversation.setSubCategory(conversation.getSubCategory());
		conversation.setLastUpdated(Timestamp.valueOf(LocalDateTime.now()));
		Conversation storedConversation = conversationDAO.addConversation(conversation);
		// add the first messages
		Message message = new Message();
		message.setConversation(storedConversation.getId());
		message.setCreateDateTime(conversation.getCreatedatetime());
		message.setMessage(conversation.getContent());
		message.setSender(conversation.getOwner());
		message.setStatus(Constants.MESSAGE_STATUS_ACTIVE);
		message = messageDAO.addMesssage(message);

		// update the conversation object with the latest message
		conversation.setLatestMessageID(message.getId());
		conversation.setLastUpdated(Timestamp.valueOf(LocalDateTime.now()));
		conversation.setLatestMessageBy(conversation.getOwner());
		conversationDAO.updatConversation(storedConversation);

		// return the stored conversation
		return storedConversation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.askconsultant.service.ConversationService#archiveConversation(long,
	 * java.lang.String)
	 */
	@Override
	public void archiveConversation(long conversationID, String userid) {
		conversationDAO.archiveConversation(conversationID, userid);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.askconsultant.service.ConversationService#listAllConversations()
	 */
	@Override
	public List<ConversationWithLatestMessageDTO> listAllConversations() {
		List<Conversation> listAllConversations = conversationDAO.listAllConversations();
		List<ConversationWithLatestMessageDTO> packageConversationWithLatestMessage = packageConversationWithLatestMessage(
				listAllConversations);
		return packageConversationWithLatestMessage;
	}

	/**
	 * @param listAllConversations
	 * @return
	 */
	private List<ConversationWithLatestMessageDTO> packageConversationWithLatestMessage(
			List<Conversation> listAllConversations) {
		List<ConversationWithLatestMessageDTO> conversationWithLatestMessageList = new ArrayList<ConversationWithLatestMessageDTO>();
		ConversationWithLatestMessageDTO conversationWithLatestMessage = new ConversationWithLatestMessageDTO();
		Message message = null;
		for (Conversation conversation : listAllConversations) {
			conversationWithLatestMessage = new ConversationWithLatestMessageDTO();
			conversationWithLatestMessage.setConversation(conversation);
			message = messageDAO.findByID(conversation.getLatestMessageID());
			// set the sender display name instead of the userid
			message.setSender(registrationService.getDisplayOrPreferredName(message.getSender()));
			conversationWithLatestMessage.setMessage(message);
			// add to list for display
			conversationWithLatestMessageList.add(conversationWithLatestMessage);
		}
		return conversationWithLatestMessageList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.askconsultant.service.ConversationService#listAllConversationsForUser(
	 * java.lang.String)
	 */
	@Override
	public List<ConversationWithLatestMessageDTO> listAllConversationsForUser(String userid) {
		List<Conversation> listActiveConversationsByUser = conversationDAO.listActiveConversationsByUser(userid);
		List<ConversationWithLatestMessageDTO> packageConversationWithLatestMessage = packageConversationWithLatestMessage(
				listActiveConversationsByUser);
		return packageConversationWithLatestMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.askconsultant.service.ConversationService#listActiveConversations()
	 */
	@Override
	public List<Conversation> listActiveConversations() {
		return conversationDAO.listAllActiveConversations();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.askconsultant.service.ConversationService#
	 * listActiveConversationsWithMessages()
	 */
	@Override
	public List<ConversationAndMessages> listActiveConversationsWithMessages() {
		List<ConversationAndMessages> conversationAndMessages = new ArrayList<ConversationAndMessages>();
		List<Conversation> activeConversations = conversationDAO.listAllActiveConversations();
		ConversationAndMessages conversationAndMessagesObj;
		for (Conversation conversation : activeConversations) {
			conversationAndMessagesObj = new ConversationAndMessages();
			conversationAndMessagesObj.setConversation(conversation);
			conversationAndMessagesObj.setMessage(messageDAO.listMessagesByConversationID(conversation.getId()));
		}
		return conversationAndMessages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.askconsultant.service.ConversationService#
	 * listActiveConversationsWithMessagesForUser(java.lang.String)
	 */
	@Override
	public List<ConversationAndMessages> listActiveConversationsWithMessagesForUser(String userid) {
		List<ConversationAndMessages> conversationAndMessages = new ArrayList<ConversationAndMessages>();
		List<Conversation> activeConversations = conversationDAO.listActiveConversationsByUser(userid);
		ConversationAndMessages conversationAndMessagesObj;
		for (Conversation conversation : activeConversations) {
			conversationAndMessagesObj = new ConversationAndMessages();
			conversationAndMessagesObj.setConversation(conversation);
			conversationAndMessagesObj.setMessage(messageDAO.listMessagesByConversationID(conversation.getId()));
		}
		return conversationAndMessages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.askconsultant.service.ConversationService#getConversation(long)
	 */
	@Override
	public Conversation getConversation(long conversationID) {
		return conversationDAO.getConversationByID(conversationID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.askconsultant.service.ConversationService#listAllConversations()
	 */
	@Override
	public List<ConversationWithLatestMessageDTO> listActiveConversationsForUser(String userid) {
		List<Conversation> converationList = new ArrayList<Conversation>();
		converationList = conversationDAO.listActiveConversationsByUser(userid);
		return packageConversationWithLatestMessage(converationList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.askconsultant.service.ConversationService#listAllConversations()
	 */
	@Override
	public List<ConversationWithLatestMessageDTO> listActiveConversationsForEmployee(String userid) {
		List<Conversation> converationList = new ArrayList<Conversation>();
		converationList = conversationDAO.listAllActiveConversations();
		return packageConversationWithLatestMessage(converationList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.askconsultant.service.ConversationService#
	 * listActiveConversationsForEmployee(java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<ConversationWithLatestMessageDTO> listActiveConversationsForEmployee(String userid, String topic,
			String subtopic, String dflt, String all) {

		
		//if all is specified and is true then get all conversations
		if(null!=all && Boolean.parseBoolean(all)) {
			return this.listActiveConversationsForEmployee(userid);
		}
		
		//if default is set then get the preferences of employee and use them to fetch the list of conversations 
		if(null!=dflt && Boolean.parseBoolean(dflt)) {
			Map<String, String> employeeConversationCategories = employeeService
					.getEmployeeConversationCategories(userid);
			String dfltTopic = employeeConversationCategories.get("primaryTopic");
			String dfltSubtopic = employeeConversationCategories.get("primarySubtopic");
			List<Conversation> listAllActiveConversations = conversationDAO.listAllActiveConversations(dfltTopic,
					dfltSubtopic);
			return packageConversationWithLatestMessage(listAllActiveConversations);
		}
		
		//if the topic and subtopic is provided then query the conversations using them
		if(null!=topic && null!=subtopic) {
			List<Conversation> listAllActiveConversations = conversationDAO.listAllActiveConversations(topic, subtopic);
			return packageConversationWithLatestMessage(listAllActiveConversations);
		}

		//if nothing matches then simply return all conversations
		return this.listActiveConversationsForEmployee(userid);
	}

}
