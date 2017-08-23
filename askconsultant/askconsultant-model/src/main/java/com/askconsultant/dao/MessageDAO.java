package com.askconsultant.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.askconsultant.model.Message;

@Stateless
public class MessageDAO {

	public MessageDAO() {
	
	}

	@PersistenceContext
	EntityManager em;
	
	public Message addMesssage(Message message){
		em.persist(message);
		return message;
	}
	
	public Message findByID(long messageID){
		return em.find(Message.class, messageID);
	}
	
	public List<Message> listAllMessages(){
		return em.createQuery("Select m From Message m").getResultList();
	}
}
