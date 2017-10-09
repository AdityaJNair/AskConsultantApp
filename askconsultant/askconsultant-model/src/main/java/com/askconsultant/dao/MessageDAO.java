package com.askconsultant.dao;

import java.sql.Timestamp;
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

	/**
	 * Adds the message to the database
	 * 
	 * @param message
	 * @return persisted message
	 */
	public Message addMesssage(Message message) {
		message.setStatus(Constants.MESSAGE_STATUS_ACTIVE);
		em.persist(message);
		return message;
	}

	/**
	 * Retrieves the message object by message id
	 * 
	 * @param messageID
	 *            The id of the message object to be retrieved
	 * @return Message object
	 */
	public Message findByID(long messageID) {
		return em.find(Message.class, messageID);
	}

	/**
	 * Returns the list of messages for a conversation id
	 * 
	 * @param conversationID
	 *            The id of the conversation
	 * @return list of messages for the conversation
	 */
	public List<Message> listMessagesByConversationID(long conversationID) {
		StringBuffer query = new StringBuffer("Select m from Message m where m.conversation=").append(String.valueOf(conversationID)).append(" order by m.createDateTime desc");
		@SuppressWarnings("unchecked")
		List<Message> resultList = em.createQuery(query.toString()).getResultList();
		return resultList;
	}

	/**
	 * Returns the list of all messages that were sent after a particular message
	 * 
	 * @param message
	 *            the message to which the replies are needed
	 * @return list of replies to the message passed in the paramter
	 */
	public List<Message> listRepliedMessagesForMessage(Message message) {
		long conversation = message.getConversation();
		Timestamp createDateTime = message.getCreateDateTime();
		@SuppressWarnings("unchecked")
		List<Message> resultList = em.createQuery(
				"Select m from Message m where m.conversation=:conversation and m.createDateTime > :createDateTime")
				.setParameter("conversation", conversation).setParameter("createDateTime", createDateTime)
				.getResultList();
		return resultList;
	}

}
