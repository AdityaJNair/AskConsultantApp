package com.askconsultant.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.askconsultant.common.ConversationHelper;
import com.askconsultant.common.MessageHelper;
import com.askconsultant.model.Conversation;
import com.askconsultant.model.Message;

/**
 * Tests the MessageDAO class
 *
 */
public class TestMessageDAO {
	private EntityManagerFactory emf;
	private EntityManager em;
	private MessageDAO messageDAO;

	/**
	 * Initialize the objects required to test
	 */
	@Before
	public void initTestCase() {
		emf = Persistence.createEntityManagerFactory("MessagePU");
		em = emf.createEntityManager();
		messageDAO = new MessageDAO();
		messageDAO.em = em;
	}

	/**
	 * Clean up tasks
	 */
	@After
	public void closeEntityManager() {
		em.close();
		emf.close();
	}

	/**
	 * Tests adding a message
	 */
	@Test
	public void addMesssage() {
		em.getTransaction().begin();
		Conversation conversation = ConversationHelper.getConversationWithAllValues();
		em.getTransaction().commit();
		Message message = MessageHelper.getMessageObjectWithAllData(conversation.getId(), "userid");
		try {
			em.getTransaction().begin();
			Message storedMessage = messageDAO.addMesssage(message);
			em.getTransaction().commit();
			assertNotNull(storedMessage);
			assertTrue(storedMessage.getId() != 0l);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * Tests listing of messages by conversation id
	 */
	@Test
	public void listMessagesByConversationID() {
		try {
			em.getTransaction().begin();
			//add messages to conversation
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid1"));
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid2"));
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid3"));
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid4"));
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(2, "userid4"));
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(2, "userid4"));
			em.getTransaction().commit();
			
			//test the method
			List<Message> listMessagesByConversationID = messageDAO.listMessagesByConversationID(1);
			assertNotNull(listMessagesByConversationID);
			assertEquals(4,listMessagesByConversationID.size());
			
			List<Message> listMessagesByConversationID2 = messageDAO.listMessagesByConversationID(2);
			assertNotNull(listMessagesByConversationID2);
			assertEquals(2,listMessagesByConversationID2.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * Tests listing of messages matching no criteria
	 * Shouldn't throw any exception but return empty list
	 */
	@Test
	public void listMessagesByConversationIDWithNoResults() {
		try {
			em.getTransaction().begin();
			//add messages to conversation
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid1"));
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid2"));
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid3"));
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid4"));
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(2, "userid4"));
			messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(2, "userid4"));
			em.getTransaction().commit();
			
			//test the method
			List<Message> listMessagesByConversationID = messageDAO.listMessagesByConversationID(5);
			assertNotNull(listMessagesByConversationID);
			assertEquals(0,listMessagesByConversationID.size());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * 
	 */
	@Test
	public void listRepliedMessagesForMessageID() {
		try {
			em.getTransaction().begin();
			//add messages to conversation
			Message message1 = messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid1"));
			//The sleep is to simulate the delay in the reply from a user
			Thread.sleep(500);
			Message message2 = messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid2"));
			Thread.sleep(500);
			Message message3 = messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid3"));
			Thread.sleep(500);
			Message message4 = messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(1, "userid4"));
			Thread.sleep(500);
			Message message5 = messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(2, "userid4"));
			Thread.sleep(500);
			Message message6 = messageDAO.addMesssage(MessageHelper.getMessageObjectWithAllData(2, "userid4"));
			Thread.sleep(500);
			em.getTransaction().commit();
			
			//test the method
			List<Message> repliedMessages = messageDAO.listRepliedMessagesForMessage(message2);
			assertNotNull(repliedMessages);
			assertEquals(2,repliedMessages.size());
			
			List<Message> repliedMessages2 = messageDAO.listRepliedMessagesForMessage(message1);
			assertNotNull(repliedMessages2);
			assertEquals(3,repliedMessages2.size());
			
			List<Message> repliedMessages3 = messageDAO.listRepliedMessagesForMessage(message5);
			assertNotNull(repliedMessages);
			assertEquals(1,repliedMessages3.size());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
