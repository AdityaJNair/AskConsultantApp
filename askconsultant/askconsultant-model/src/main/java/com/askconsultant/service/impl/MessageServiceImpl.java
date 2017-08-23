package com.askconsultant.service.impl;

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
	public List<Message> listAllMessages(){
		return messageDAO.listAllMessages();
	}
	
	@Override
	public Message addMessage(Message message){
		return messageDAO.addMesssage(message);
	}
	
}
