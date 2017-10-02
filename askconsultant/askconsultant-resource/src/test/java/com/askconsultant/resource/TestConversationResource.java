package com.askconsultant.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.askconsultant.common.ConversationHelper;
import com.askconsultant.common.FileUtil;
import com.askconsultant.common.JSONElementHelper;
import com.askconsultant.common.MessageHelper;
import com.askconsultant.model.Conversation;
import com.askconsultant.resource.converter.ConversationJSONConverter;
import com.askconsultant.resource.converter.MessageJSONConverter;
import com.askconsultant.resource.converter.OperationFailureJSONConvertor;
import com.askconsultant.service.AuthenticationService;
import com.askconsultant.service.ConversationService;
import com.askconsultant.service.MessageService;
import com.askconsultant.service.dto.ConversationWithLatestMessageDTO;

/**
 * Tests the methods of the ConversationResource class
 *
 */
public class TestConversationResource {

	ConversationService mockConversationService;
	MessageService mockMessageService;
	ConversationJSONConverter mockConversationJSONConverter;
	MessageJSONConverter mockMessageJSONConverter;
	AuthenticationService mockAuthService;
	OperationFailureJSONConvertor mockOpFailureJSONConverter;

	UserConversationResource conversationResource;

	@Before
	public void init() {
		mockConversationService = Mockito.mock(ConversationService.class);
		mockMessageService = Mockito.mock(MessageService.class);
		mockConversationJSONConverter = Mockito.mock(ConversationJSONConverter.class);
		mockMessageJSONConverter = Mockito.mock(MessageJSONConverter.class);
		mockOpFailureJSONConverter = Mockito.mock(OperationFailureJSONConvertor.class);
		mockAuthService = Mockito.mock(AuthenticationService.class);

		// set the objects
		conversationResource = new UserConversationResource();
		conversationResource.conversationService = mockConversationService;
		conversationResource.conversationJSONConverter = mockConversationJSONConverter;
		conversationResource.messageJSONConverter = mockMessageJSONConverter;
		conversationResource.messageService = mockMessageService;
		conversationResource.authService = mockAuthService;
		conversationResource.opFailureJSONConverter = mockOpFailureJSONConverter;
	}

	/**
	 * Tests adding of conversation
	 */
	@Test
	public void addConversation() {
		try {
			// set the expectations
			when(mockConversationJSONConverter.convert(Mockito.anyVararg()))
					.thenReturn(ConversationHelper.getConversationWithAllValues(1));
			when(mockConversationService.addConversation(Mockito.anyVararg()))
					.thenReturn(ConversationHelper.getConversationWithAllValues(1));
			when(mockConversationJSONConverter.convertToJsonElement(Mockito.any(Conversation.class))).thenReturn(
					JSONElementHelper.returnConversationJSONObjectValues(1, "name", "owner", "datetime", "category"));

			// test the actual method
			Response response = conversationResource.addConversation("userid",
					FileUtil.readJSONFile("TEST1_CONVERSATION_REQUEST_JSON.json"));
			assertNotNull(response);
			assertEquals(201, response.getStatus());
			assertTrue(response.getEntity().toString().length() > 0);
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * Tests adding of conversation when a exception is thrown during conversion of
	 * JSON to object there should be a proper response code with proper message
	 */
	@Test
	public void addConversationWithExceptionFromConverter() {
		try {
			// set the expectations
			when(mockConversationJSONConverter.convert(Mockito.anyVararg()))
					.thenThrow(new NullPointerException("message"));
			when(mockOpFailureJSONConverter.convertToJsonElement(Mockito.anyVararg()))
					.thenReturn(JSONElementHelper.returnGenericOpFailureJSONObjectValues("message"));

			// test the actual method
			Response response = conversationResource.addConversation("userid",
					FileUtil.readJSONFile("TEST1_CONVERSATION_REQUEST_JSON.json"));
			assertNotNull(response);
			assertEquals(500, response.getStatus());
			assertTrue(response.getEntity().toString().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

//	/**
//	 * Tests listing of all conversations for employee
//	 */
//	@Test
//	public void listAllConversationsForEmployee() {
//		try {
//			// set the expectations
//			when(mockConversationService.listActiveConversations()).thenReturn(new ArrayList<Conversation>());
//			when(mockAuthService.isEmployee(Mockito.anyVararg())).thenReturn(true);
//			when(mockConversationJSONConverter.convertToJsonElement(new ArrayList<ConversationWithLatestMessageDTO>()))
//					.thenReturn(JSONElementHelper.returnConversationJSONArray());
//			Response response = conversationResource.listAllConversations("userid", "topic", "subtopic");
//			assertNotNull(response);
//			assertEquals(201, response.getStatus());
//		} catch (Exception e) {
//			fail();
//		}
//	}

	/**
	 * Tests listing of all conversations for user
	 */
//	@Test
//	public void listAllConversationsForUser() {
//		try {
//			// set the expectations
//			when(mockConversationService.listActiveConversations()).thenReturn(new ArrayList<Conversation>());
//			when(mockAuthService.isEmployee(Mockito.anyVararg())).thenReturn(false);
//			when(mockConversationJSONConverter.convertToJsonElement(new ArrayList<ConversationWithLatestMessageDTO>()))
//					.thenReturn(JSONElementHelper.returnConversationJSONArray());
//			Response response = conversationResource.listAllConversations("userid", "topic", "subtopic");
//			assertNotNull(response);
//			assertEquals(201, response.getStatus());
//		} catch (Exception e) {
//			fail();
//		}
//	}

//	/**
//	 * Tests listing of all conversations when an exception is thrown from the
//	 * service
//	 */
//	@Test
//	public void listAllConversations_ThrowsException() {
//		try {
//			// set the expectations
//			when(mockAuthService.isEmployee(Mockito.anyVararg())).thenReturn(true);
//			when(mockConversationService.listAllConversations()).thenThrow(new NullPointerException("message"));
//			when(mockOpFailureJSONConverter.convertToJsonElement(Mockito.anyVararg()))
//					.thenReturn(JSONElementHelper.returnGenericOpFailureJSONObjectValues("message"));
//			Response response = conversationResource.listAllConversations("someuser", "topic","subtopic");
//			assertNotNull(response);
//			assertEquals(201, response.getStatus());
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail();
//		}
//	}

	/**
	 * Tests the fetching of conversation by id when the service method throws an
	 * Exception
	 */
	@Test
	public void getConversation_ServiceException() {
		try {
			//set expectations
			when(mockConversationService.getConversation(Mockito.anyLong()))
					.thenThrow(new NullPointerException("message"));
			when(mockOpFailureJSONConverter.convertToJsonElement(Mockito.anyVararg()))
					.thenReturn(JSONElementHelper.returnGenericOpFailureJSONObjectValues("message"));
			conversationResource.getConversation(1, "userid");
			//call test method
			Response response = conversationResource.getConversation(1, "someuser");
			assertNotNull(response);
			assertEquals(500, response.getStatus());
			assertTrue(response.getEntity().toString().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * Tests the fetching of conversation by id 
	 * Exception
	 */
	@Test
	public void getConversation() {
		try {
			//set expectations
			when(mockConversationService.getConversation(Mockito.anyLong()))
					.thenReturn(ConversationHelper.getConversationWithAllValues(1));
			when(mockConversationJSONConverter.convertToJsonElement(Mockito.any(Conversation.class))).thenReturn(
					JSONElementHelper.returnConversationJSONObjectValues(1, "name", "owner", "datetime", "category"));
			//call test method
			Response response = conversationResource.getConversation(1, "someuser");
			assertNotNull(response);
			assertEquals(201, response.getStatus());
			assertTrue(response.getEntity().toString().length() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
	/**
	 * Tests the listing of all messages for a given conversation id
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void listMessagesForConversation() {
		try {
			when(mockMessageService.listMessagesForConversation(Mockito.anyLong())).thenReturn(MessageHelper.getListOfMessagesForConversation(1));
			when(mockMessageJSONConverter.convertToJsonElement(Mockito.anyList())).thenReturn(JSONElementHelper.returnMessageJSONArray());
			Response response = conversationResource.listMessagesForConversation(1);
			assertNotNull(response);
			assertEquals(201, response.getStatus());
			assertTrue(response.getEntity().toString().length() > 0);
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	 * Tests the listing of all messages for a given conversation id when the
	 * service method throws Exception
	 */
	@Test
	public void listMessagesForConversation_Exception() {
		try {
			when(mockMessageService.listMessagesForConversation(Mockito.anyLong())).thenThrow(new NullPointerException("message"));
			when(mockOpFailureJSONConverter.convertToJsonElement(Mockito.anyVararg()))
			.thenReturn(JSONElementHelper.returnGenericOpFailureJSONObjectValues("message"));
			Response response = conversationResource.listMessagesForConversation(1);
			assertNotNull(response);
			assertEquals(500, response.getStatus());
			assertTrue(response.getEntity().toString().length() > 0);
		}catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
