package com.askconsultant.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

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
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);
		Root<Message> root = criteriaQuery.from(Message.class);
		criteriaQuery.select(root);

		ParameterExpression<Long> params = criteriaBuilder.parameter(Long.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("conversation"), params));

		TypedQuery<Message> query = em.createQuery(criteriaQuery);
		query.setParameter(params, conversationID);

		return query.getResultList();
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
