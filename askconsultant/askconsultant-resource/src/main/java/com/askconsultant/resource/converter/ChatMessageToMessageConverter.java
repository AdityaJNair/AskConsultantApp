package com.askconsultant.resource.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;

import com.askconsultant.model.Message;
import com.askconsultant.service.dto.ChatMessage;

/**
 * Converter to convert the user interface side object representing the chat message to 
 * the model (database side) object that will be persisted.
 *
 */
@ApplicationScoped
public class ChatMessageToMessageConverter {

	/**
	 * Converts the user interface side object to persistence object
	 * @param chatMessage
	 * @return
	 */
	public Message convertFromChatMessage(ChatMessage chatMessage) {
		Message message = new Message();
		message.setConversation(chatMessage.getConversationid());
		message.setCreateDateTime(Timestamp.valueOf(LocalDateTime.now()));
		message.setMessage(chatMessage.getMessage());
		message.setSender(chatMessage.getUserid());
		return message;
	}
	
}

