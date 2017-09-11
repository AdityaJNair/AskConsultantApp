package com.askconsultant.common;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;

import com.askconsultant.model.Message;

@Ignore
public class MessageHelper {

	public static Message getMessageWithValues(long id, String sender, long conversationId, String strMessage) {
		Message message = new Message();
		message.setId(id);
		message.setSender(sender);
		message.setMessage(strMessage);
		message.setCreateDateTime(Timestamp.valueOf(LocalDateTime.now()));
		return message;
	}
	
	public static List<Message> getListOfMessagesForConversation(long conversationId){
		List<Message> messageList = new ArrayList<Message>();
		messageList.add(getMessageWithValues(1,"sender",conversationId,"message1"));
		messageList.add(getMessageWithValues(2,"sender",conversationId,"message2"));
		messageList.add(getMessageWithValues(3,"sender",conversationId,"message3"));
		messageList.add(getMessageWithValues(4,"sender",conversationId,"message4"));
		return messageList;
	}
}
