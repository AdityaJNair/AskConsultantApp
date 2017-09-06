package com.askconsultant.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.askconsultant.dao.MessageDAO;
import com.askconsultant.model.Message;
import com.askconsultant.service.MessageService;

/**
 * This class implements the services required for storing and retrieving messages
 */
@Stateless
public class MessageServiceImpl implements MessageService{
	
	public MessageServiceImpl() {
	}

	/**
	 * MessageDAO to interact with message tables
	 */
	@Inject
	private MessageDAO messageDAO;
 
	
	/* (non-Javadoc)
	 * @see com.askconsultant.service.MessageService#addMessage(com.askconsultant.model.Message)
	 */
	@Override
	public Message addMessage(Message message){
		message.setCreateDateTime(Timestamp.valueOf(LocalDateTime.now()));
		return messageDAO.addMesssage(message);
	}


	/* (non-Javadoc)
	 * @see com.askconsultant.service.MessageService#listMessagesForConversation(long)
	 */
	@Override
	public List<Message> listMessagesForConversation(long conversationID) {
		return messageDAO.listMessagesByConversationID(conversationID);
	}


	/* (non-Javadoc)
	 * @see com.askconsultant.service.MessageService#listRepliesForMessage(long, long)
	 */
	@Override
	public List<Message> listRepliesForMessage(long conversationId, long messageid) {
		Message message = new Message(conversationId,messageid);
		return messageDAO.listRepliedMessagesForMessage(message);
	}


	/* (non-Javadoc)
	 * @see com.askconsultant.service.MessageService#getMessage(long)
	 */
	@Override
	public Message getMessage(long messageID) {
		return messageDAO.findByID(messageID);
	}
	
}
