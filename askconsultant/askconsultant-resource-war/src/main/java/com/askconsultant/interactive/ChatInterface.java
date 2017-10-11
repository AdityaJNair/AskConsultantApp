package com.askconsultant.interactive;

import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.askconsultant.dao.Constants;
import com.askconsultant.model.Conversation;
import com.askconsultant.model.Message;
import com.askconsultant.resource.converter.ChatMessageJSONDecoder;
import com.askconsultant.resource.converter.ChatMessageJSONEncoder;
import com.askconsultant.resource.converter.ChatMessageToMessageConverter;
import com.askconsultant.service.ChatInteractionService;
import com.askconsultant.service.ChatSessionService;
import com.askconsultant.service.ConversationService;
import com.askconsultant.service.MessageService;
import com.askconsultant.service.RegistrationService;
import com.askconsultant.service.dto.ChatMessage;

@ServerEndpoint(value = "/interactive/users/{userid}/conversations/{conversationid}/chat", encoders = {
		ChatMessageJSONEncoder.class }, decoders = { ChatMessageJSONDecoder.class })
public class ChatInterface {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	ChatSessionService chatRegister;

	@Inject
	ChatMessageToMessageConverter chatConverter;

	@Inject
	MessageService messageService;

	@Inject
	ChatInteractionService chatInteractionService;
	
	@Inject
	RegistrationService registrationService;
	
	@Inject
	ConversationService conversationService;

	/**
	 * On connection open add the session to live sessions
	 * 
	 * @param session
	 * @param userid
	 * @param conversationid
	 */
	@OnOpen
	public void onConnectionOpen(Session session, @PathParam("userid") String userid,
			@PathParam("conversationid") String conversationid) {
		logger.info("Connection opened for userid:" + userid + ", sessionid:" + session.getId());
		chatRegister.addSessionToConversation(Long.parseLong(conversationid), session);
	}

	/**
	 * Receive chat message, store and broadcast to peers in the conversation
	 * 
	 * @param text
	 * @param client
	 * @param userid
	 * @param conversationid
	 */
	@OnMessage
	public void receiveAndSendMessage(ChatMessage message, Session client, @PathParam("userid") String userid,
			@PathParam("conversationid") String conversationid) {
		
		long longConversationID = Long.parseLong(conversationid);
		Conversation conversation = conversationService.getConversation(longConversationID);
		//process messages to conversation only if active
		if(conversation.getStatus().equals(Constants.CONVERSATION_STATUS_ACTIVE)) {
			message.setUserid(userid);
			message.setConversationid(longConversationID);
			Message messageObj = chatConverter.convertFromChatMessage(message);
			//add the message to database
			messageService.addMessage(messageObj);
			message.setSentAt(messageObj.getCreateDateTime().toLocalDateTime().toString());
			//set the properties 
			chatInteractionService.setProperties(longConversationID, message);
			//send replies to listeners
			chatInteractionService.sendRepliesToListeners(chatRegister, longConversationID, message);
		}
		
	}

	/**
	 * Clean up session from the peer list on close
	 * 
	 * @param session
	 */
	@OnClose
	public void onConnectionClose(Session session) {
		logger.info("Connection close sessionid:" + session.getId());
		chatRegister.addToClosedSessions(session);
	}

}