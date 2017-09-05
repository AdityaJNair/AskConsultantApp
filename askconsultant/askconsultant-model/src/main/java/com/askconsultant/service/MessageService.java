package com.askconsultant.service;

import javax.ejb.Local;

import com.askconsultant.model.Message;

@Local
public interface MessageService {

	Message addMessage(Message message);

}
