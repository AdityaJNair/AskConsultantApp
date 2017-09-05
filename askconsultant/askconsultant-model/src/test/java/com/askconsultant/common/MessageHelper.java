package com.askconsultant.common;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.askconsultant.dao.Constants;
import com.askconsultant.model.Message;

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

}
