package com.askconsultant.common;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.askconsultant.model.Conversation;

public class ConversationHelper {

	public static Conversation getConversationWithAllValues(long id) {
		Conversation conversation = new Conversation();
		conversation.setCategory("category");
		conversation.setId(id);
		conversation.setArchivinguser("archivinguser");
		conversation.setName("name");
		conversation.setOwner("owner");
		conversation.setCreatedatetime(Timestamp.valueOf(LocalDateTime.now()));
		return conversation;
	}
	
}

