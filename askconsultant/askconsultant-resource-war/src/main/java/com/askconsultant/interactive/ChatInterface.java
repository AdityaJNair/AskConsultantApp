package com.askconsultant.interactive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// list of sessions
	private static List<Session> peers = Collections.synchronizedList(new ArrayList<Session>());
	// Map of conversation id to sessions
	private static Map<String, List<Session>> liveSessions = Collections
			.synchronizedMap(new HashMap<String, List<Session>>());
	private Logger logger = LoggerFactory.getLogger(getClass());

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
		// add session and conversation id
		peers.add(session);
		List<Session> sessions = liveSessions.get(conversationid);
		if (null == sessions) {
			liveSessions.put(conversationid, peers);
		} else {
			sessions.add(session);
		}
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
		// add message to conversation
		// TODO: Add message to database
		// broadcast message to other peers in the conversation
		List<Session> peers = liveSessions.get(conversationid);
		if (peers != null && !peers.isEmpty()) {
			ChatMessage chatmessage = new ChatMessage();
			for (Session session : peers) {
				chatmessage.setMessage(message.getMessage());
				chatmessage.setDisplayName("test id");
				chatmessage.setConversationid(Long.parseLong(conversationid));
				chatmessage.setUserid(userid);
				chatmessage.setSentAt("date time");
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
		peers.remove(session);
	}

}