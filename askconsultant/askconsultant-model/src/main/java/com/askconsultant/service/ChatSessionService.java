package com.askconsultant.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.websocket.Session;

/**
 * Provides methods to manage online chat sessions opened via websockets
 *
 */
@Singleton
public class ChatSessionService {

	private final Map<Long, Set<Session>> liveConversations = new HashMap<Long, Set<Session>>();
	private final Set<Session> closedSessions = new HashSet<Session>();
	
	
	/**
	 * Stores a newly opened session
	 * 
	 * @param conversationid
	 * @param session
	 */
	@Lock(LockType.WRITE)
	public void addSessionToConversation(long conversationid, Session session) {
		Set<Session> existingLiveSessions = liveConversations.get(conversationid);
		if(existingLiveSessions==null) {
			existingLiveSessions = new HashSet<Session>();
			existingLiveSessions.add(session);
			liveConversations.put(conversationid,existingLiveSessions);
		}else {
			existingLiveSessions.add(session);
		}
	}
	
	/**
	 * Fetches all the online sessions for a given conversationid
	 * @param conversationid
	 * @return
	 */
	@Lock(LockType.READ)
	public Set<Session> getAllSessionsForConversationID(long conversationid){
		Set<Session> sessions = this.liveConversations.get(conversationid);
		if(sessions==null) {
			sessions = new HashSet<>();
		}
		return sessions;
	}
	
	/**
	 * Fetches all stored conversations
	 * @return
	 */
	@Lock(LockType.READ)
	public Set<Session> getAllSessions(){
		Set<Long> keySet = liveConversations.keySet();
		Set<Session> allSessions = new HashSet<Session>();
		for(Long conversationid : keySet) {
			Set<Session> sessions = liveConversations.get(conversationid);
			for(Session session : allSessions) {
				allSessions.add(session);
			}
		}
		return allSessions;
	}
	
	/**
	 * Adds the provided session to the repository of closed sessions
	 * @param session
	 */
	@Lock(LockType.WRITE)
	public void addToClosedSessions(Session session) {
		closedSessions.add(session);
	}
	
	/**
	 * Removes all closed session
	 */
	@Lock(LockType.WRITE)
	public void removeClosedSessions() {
		Set<Session> allSessions = getAllSessions();
		for(Session session : closedSessions) {
			if(allSessions.contains(session)) {
				allSessions.remove(session);
			}
		}
		closedSessions.clear();
	}
	
}
