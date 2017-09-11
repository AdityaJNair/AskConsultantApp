package com.askconsultant.common;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.mockito.Mockito;

import com.askconsultant.dao.Constants;
import com.askconsultant.model.Message;

/**
 * Helper class to return Message related objects
 *
 */
@Ignore
public class MessageHelper {

	public static Message getMessageObjectWithAllData(long conversationId, String senderID) {
		Message message = new Message();
		message.setMessage("This is a test message");
		message.setConversation(conversationId);
		message.setSender(senderID);
		message.setStatus(Constants.MESSAGE_STATUS_ACTIVE);
		message.setCreateDateTime(Timestamp.valueOf(LocalDateTime.now()));
		return message;
	}
	
	public static List<Message> getListOfMessages(){
		List<Message> messages = new ArrayList<Message>();
		messages.add(getMockMessage());
		messages.add(getMockMessage());
		messages.add(getMockMessage());
		messages.add(getMockMessage());
		messages.add(getMockMessage());
		return messages;
	}
	
	public static Message getMockMessage() {
		Message message = Mockito.mock(Message.class);
		return message;
	}

}
