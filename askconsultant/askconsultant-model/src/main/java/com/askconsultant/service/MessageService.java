package com.askconsultant.service;

import java.util.List;

import javax.ejb.Local;

import com.askconsultant.model.Message;

@Local
public interface MessageService {

	Message addMessage(Message message);
	List listAllMessages();

}
