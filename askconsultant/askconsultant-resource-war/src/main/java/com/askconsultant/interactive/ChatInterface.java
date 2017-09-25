package com.askconsultant.interactive;

import java.util.Set;

import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.askconsultant.interactive.dto.ChatMessage;
import com.askconsultant.resource.converter.ChatMessageJSONDecoder;
import com.askconsultant.resource.converter.ChatMessageJSONEncoder;

@ServerEndpoint(value = "/interactive/users/{userid}/conversations/{conversationid}/chat", encoders = {
		ChatMessageJSONEncoder.class }, decoders = { ChatMessageJSONDecoder.class })
public class ChatInterface {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	ChatSessionRegister chatRegister;

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
		Set<Session> peers = chatRegister.getAllSessionsForConversationID(Long.parseLong(conversationid));
		if (!peers.isEmpty()) {
			ChatMessage chatmessage = new ChatMessage();
			for (Session session : peers) {
				chatmessage.setMessage(message.getMessage());
				chatmessage.setDisplayName("test id");
				chatmessage.setConversationid(Long.parseLong(conversationid));
				chatmessage.setUserid(userid);
				chatmessage.setSentAt("date time");
				chatmessage.setSenderSent(true);
				session.getAsyncRemote().sendObject(chatmessage);
			}
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