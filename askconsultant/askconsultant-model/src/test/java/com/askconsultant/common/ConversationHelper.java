package com.askconsultant.common;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.mockito.Mockito;

import com.askconsultant.dao.Constants;
import com.askconsultant.model.Conversation;

/**
 * Helper class to return the Conversation object
 *
 */
@Ignore
public class ConversationHelper {

	public static Conversation getConversationWithAllValues() {

		Conversation conversation = new Conversation();
		conversation.setName("HR Related");
		conversation.setOwner("userid");
		conversation.setStatus(Constants.CONVERSATION_STATUS_ACTIVE);
		conversation.setCreatedatetime(Timestamp.valueOf(LocalDateTime.now()));
		conversation.setCategory("HR");
		conversation.setSubCategory("SubCategory HR");
		return conversation;
	}
	
	public static Conversation getMockConversation() {
		Conversation conversation = Mockito.mock(Conversation.class);
		return conversation;
	}
	
	public static Conversation getConversationWithAllValuesForID(long id) {

		Conversation conversation = new Conversation();
		conversation.setName("HR Related");
		conversation.setOwner("userid");
		conversation.setStatus(Constants.CONVERSATION_STATUS_ACTIVE);
		conversation.setCreatedatetime(Timestamp.valueOf(LocalDateTime.now()));
		conversation.setCategory("HR");
		conversation.setId(id);
		return conversation;
	}


	public static Conversation getConversationWithAllValuesForUserAndConversationName(String conversationName,String user) {

		Conversation conversation = new Conversation();
		conversation.setName("HR Related");
		conversation.setOwner(user);
		conversation.setStatus(Constants.CONVERSATION_STATUS_ACTIVE);
		conversation.setCreatedatetime(Timestamp.valueOf(LocalDateTime.now()));
		conversation.setCategory("HR");
		return conversation;
	}
	
	public static Conversation getConversationWithAllValuesForUserAndConversationNameAndStatus(String conversationName,String user,String status) {

		Conversation conversation = new Conversation();
		conversation.setName("HR Related");
		conversation.setOwner(user);
		conversation.setStatus(status);
		conversation.setCreatedatetime(Timestamp.valueOf(LocalDateTime.now()));
		conversation.setCategory("HR");
		return conversation;
	}
	
	public static List<Conversation> getListOfValidConversations(){
		List<Conversation> conversation = new ArrayList<Conversation>();
		conversation.add(getMockConversation());
		conversation.add(getMockConversation());
		conversation.add(getMockConversation());
		conversation.add(getMockConversation());
		conversation.add(getMockConversation());
		return conversation;
	}
}
