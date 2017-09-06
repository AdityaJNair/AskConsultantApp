package com.askconsultant.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.askconsultant.dao.MessageDAO;
import com.askconsultant.model.Message;
import com.askconsultant.service.MessageService;

@Stateless
public class MessageServiceImpl implements MessageService{
	
	public MessageServiceImpl() {
	}

	@Inject
	private MessageDAO messageDAO;
 
	
	@Override
	public Message addMessage(Message message){
		message.setCreateDateTime(Timestamp.valueOf(LocalDateTime.now()));
		return messageDAO.addMesssage(message);
	}


	@Override
	public List<Message> listMessagesForConversation(long conversationID) {
		return messageDAO.listMessagesByConversationID(conversationID);
	}


	@Override
	public List<Message> listRepliesForMessage(long conversationId, long messageid) {
		Message message = new Message(conversationId,messageid);
		return messageDAO.listRepliedMessagesForMessage(message);
	}


	@Override
	public Message getMessage(long messageID) {
		return messageDAO.findByID(messageID);
	}
	
}
