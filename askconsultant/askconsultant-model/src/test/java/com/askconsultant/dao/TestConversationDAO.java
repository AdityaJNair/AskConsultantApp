package com.askconsultant.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.askconsultant.common.ConversationHelper;
import com.askconsultant.model.Conversation;

/**
 * Tests the ConversationDAO class
 *
 */
public class TestConversationDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private ConversationDAO conversationDAO;

	@Before
	public void initTestCase() {
		emf = Persistence.createEntityManagerFactory("MessagePU");
		em = emf.createEntityManager();
		conversationDAO = new ConversationDAO();
		conversationDAO.em = em;
	}

	@After
	public void closeEntityManager() {
		em.close();
		emf.close();
	}

	/**
	 * Tests adding of a conversation to the database
	 */
	@Test
	public void addConversation() {
		em.getTransaction().begin();
		try {
			Conversation conversation = conversationDAO
					.addConversation(ConversationHelper.getConversationWithAllValues());
			em.getTransaction().commit();
			assertTrue(conversation.getId() != 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Tests if the conversation can be retrieved using the conversation id
	 */
	@Test
	public void getConversationByID() {
		em.getTransaction().begin();
		try {
			Conversation conversation = conversationDAO
					.addConversation(ConversationHelper.getConversationWithAllValues());
			em.getTransaction().commit();
			Conversation conversationByID = conversationDAO.getConversationByID(conversation.getId());
			assertNotNull(conversationByID);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void listActiveConversationsByUserWithData() {
		em.getTransaction().begin();
		try {
			// add conversations first for different users
			conversationDAO.addConversation(ConversationHelper
					.getConversationWithAllValuesForUserAndConversationName("conversation1", "user1"));
			conversationDAO.addConversation(ConversationHelper
					.getConversationWithAllValuesForUserAndConversationName("conversation2", "user1"));
			conversationDAO.addConversation(ConversationHelper
					.getConversationWithAllValuesForUserAndConversationName("conversation3", "user1"));
			conversationDAO.addConversation(ConversationHelper
					.getConversationWithAllValuesForUserAndConversationName("conversation4", "user2"));
			conversationDAO.addConversation(ConversationHelper
					.getConversationWithAllValuesForUserAndConversationName("conversation5", "user2"));
			conversationDAO.addConversation(ConversationHelper
					.getConversationWithAllValuesForUserAndConversationName("conversation6", "user2"));
			em.getTransaction().commit();

			List<Conversation> listActiveConversationsByUser = conversationDAO.listActiveConversationsByUser("user2");
			assertNotNull(listActiveConversationsByUser);
			assertEquals(3, listActiveConversationsByUser.size());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	/**
	 * Tests behavior when there is no data for the query
	 */
	@Test
	public void listActiveConversationsByUserWithoutData() {
		em.getTransaction().begin();
		try {
			List<Conversation> listActiveConversationsByUser = conversationDAO.listActiveConversationsByUser("user2");
			assertNotNull(listActiveConversationsByUser);
			assertEquals(0, listActiveConversationsByUser.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void archiveConversation() {
		em.getTransaction().begin();
		try {
			Conversation addConversation = conversationDAO.addConversation(ConversationHelper
					.getConversationWithAllValuesForUserAndConversationName("conversation1", "user1"));
			conversationDAO.addConversation(ConversationHelper
					.getConversationWithAllValuesForUserAndConversationName("conversation2", "user1"));
			em.getTransaction().commit();
			em.getTransaction().begin();
			conversationDAO.archiveConversation(addConversation.getId(), "conversation1");
			em.getTransaction().commit();
			assertEquals(Constants.CONVERSATION_STATUS_ARCHIVED, addConversation.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void listAllActiveConversations() {
		try {
			em.getTransaction().begin();
			// add conversations first for different users
			conversationDAO.addConversation(
					ConversationHelper.getConversationWithAllValuesForUserAndConversationNameAndStatus("Conversation 1",
							"userid1", Constants.CONVERSATION_STATUS_ACTIVE));

			conversationDAO.addConversation(
					ConversationHelper.getConversationWithAllValuesForUserAndConversationNameAndStatus("Conversation 2",
							"userid1", Constants.CONVERSATION_STATUS_ACTIVE));

			conversationDAO.addConversation(
					ConversationHelper.getConversationWithAllValuesForUserAndConversationNameAndStatus("Conversation 3",
							"userid2", Constants.CONVERSATION_STATUS_ARCHIVED));

			em.getTransaction().commit();
			em.getTransaction().begin();
			List<Conversation> listAllActiveConversations = conversationDAO.listAllActiveConversations();
			assertNotNull(listAllActiveConversations);
			assertEquals(2, listAllActiveConversations.size());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void listAllConversations() {
		try {
			em.getTransaction().begin();
			// add conversations first for different users
			conversationDAO.addConversation(
					ConversationHelper.getConversationWithAllValuesForUserAndConversationNameAndStatus("Conversation 1",
							"userid1", Constants.CONVERSATION_STATUS_ACTIVE));

			conversationDAO.addConversation(
					ConversationHelper.getConversationWithAllValuesForUserAndConversationNameAndStatus("Conversation 2",
							"userid1", Constants.CONVERSATION_STATUS_ACTIVE));

			conversationDAO.addConversation(
					ConversationHelper.getConversationWithAllValuesForUserAndConversationNameAndStatus("Conversation 3",
							"userid2", Constants.CONVERSATION_STATUS_ARCHIVED));

			em.getTransaction().commit();
			em.getTransaction().begin();
			List<Conversation> listAllActiveConversations = conversationDAO.listAllConversations();
			assertNotNull(listAllActiveConversations);
			assertEquals(3, listAllActiveConversations.size());

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
