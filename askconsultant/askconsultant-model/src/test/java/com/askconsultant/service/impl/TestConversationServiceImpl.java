package com.askconsultant.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.askconsultant.common.ConversationHelper;
import com.askconsultant.common.MessageHelper;
import com.askconsultant.dao.ConversationDAO;
import com.askconsultant.dao.MessageDAO;
import com.askconsultant.service.ConversationService;
import com.askconsultant.service.dto.ConversationAndMessages;

public class TestConversationServiceImpl {

	private ConversationDAO conversationDAO;
	private ConversationService conversationService;
	private MessageDAO messageDAO;

	@Before
	public void init() {
		conversationService = new ConversationServiceImpl() {
		};
		conversationDAO = mock(ConversationDAO.class);
		messageDAO = mock(MessageDAO.class);
		((ConversationServiceImpl) conversationService).conversationDAO = conversationDAO;
		((ConversationServiceImpl) conversationService).messageDAO = messageDAO;
	}

	@Test
	public void listActiveConversationsWithMessages() {
		try {
			// set the mock expectations
			when(conversationDAO.listAllActiveConversations()).thenReturn(ConversationHelper.getListOfValidConversations());
			when(messageDAO.listMessagesByConversationID(0)).thenReturn(MessageHelper.getListOfMessages());
			List<ConversationAndMessages> listActiveConversationsWithMessages = conversationService
					.listActiveConversationsWithMessages();
			assertNotNull(listActiveConversationsWithMessages);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
