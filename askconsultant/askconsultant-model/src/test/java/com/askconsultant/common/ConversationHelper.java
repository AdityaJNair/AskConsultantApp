package com.askconsultant.common;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.askconsultant.dao.Constants;
import com.askconsultant.model.Conversation;

public class ConversationHelper {

	public static Conversation getConversationWithAllValues() {

		Conversation conversation = new Conversation();
		conversation.setName("HR Related");
		conversation.setOwner("userid");
		conversation.setStatus(Constants.CONVERSATION_STATUS_ACTIVE);
		conversation.setCreatedatetime(Timestamp.valueOf(LocalDateTime.now()));
		return conversation;
	}

	public static Conversation getConversationWithAllValuesForUserAndConversationName(String conversationName,String user) {

		Conversation conversation = new Conversation();
		conversation.setName("HR Related");
		conversation.setOwner(user);
		conversation.setStatus(Constants.CONVERSATION_STATUS_ACTIVE);
		conversation.setCreatedatetime(Timestamp.valueOf(LocalDateTime.now()));
		return conversation;
	}
	
	public static Conversation getConversationWithAllValuesForUserAndConversationNameAndStatus(String conversationName,String user,String status) {

		Conversation conversation = new Conversation();
		conversation.setName("HR Related");
		conversation.setOwner(user);
		conversation.setStatus(status);
		conversation.setCreatedatetime(Timestamp.valueOf(LocalDateTime.now()));
		return conversation;
	}
}
