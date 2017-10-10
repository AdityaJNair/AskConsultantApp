package com.askconsultant.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.askconsultant.common.ConversationHelper;
import com.askconsultant.common.MessageHelper;
import com.askconsultant.dao.ConversationDAO;
import com.askconsultant.dao.MessageDAO;
import com.askconsultant.model.Conversation;
import com.askconsultant.model.Message;
import com.askconsultant.service.ConversationService;
import com.askconsultant.service.RegistrationService;
import com.askconsultant.service.dto.ConversationWithLatestMessageDTO;

/**
 * Test class for Conversation
 *
 */
public class TestConversationServiceImpl {

	private ConversationDAO conversationDAO;
	private ConversationService conversationService;
	private MessageDAO messageDAO;
	private RegistrationService registrationService;

	@Before
	public void init() {
		conversationService = new ConversationServiceImpl() {
		};
		conversationDAO = mock(ConversationDAO.class);
		messageDAO = mock(MessageDAO.class);
		registrationService = mock(RegistrationService.class);
		((ConversationServiceImpl) conversationService).conversationDAO = conversationDAO;
		((ConversationServiceImpl) conversationService).messageDAO = messageDAO;
		((ConversationServiceImpl) conversationService).registrationService = registrationService;
	}

	
	/**
	 * Tests adding of a conversation
	 */
	@Test
	public void addConversation() {
//		try {
//			when(conversationDAO.addConversation(any(Conversation.class))).thenReturn(ConversationHelper.getConversationWithAllValuesForID(1));
//			when(messageDAO.addMesssage(any(Message.class))).thenReturn(MessageHelper.getMessageObjectWithAllData(1, "userid"));
//			//test the method
//			conversationService.addConversation(ConversationHelper.getConversationWithAllValuesForID(1));
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
	}
	
	/**
	 * Tests archiving method
	 * Note: As the call has no logic and simply delegates the archiving to the dao class, there is nothing much to mock
	 * or assert
	 */
	@Test
	public void archiveConversation() {
		try {
			conversationService.archiveConversation(1l, "userid");
			//test the method
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * Tests listing of conversation
	 */
	@Test
	public void listAllConversations() {
//		try {
//			when(conversationDAO.listAllConversations()).thenReturn(ConversationHelper.getListOfValidConversations());
//			when(messageDAO.findByID(1l)).thenReturn(MessageHelper.getMessageObjectWithAllData(1l, "userid"));
//			when(registrationService.getDisplayOrPreferredName(MessageHelper.getMessageObjectWithAllData(1l, "userid").getSender())).thenReturn("displayname");
//			
//			List<ConversationWithLatestMessageDTO> listAllConversations = conversationService.listAllConversations();
//			assertNotNull(listAllConversations);
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
	}

}
