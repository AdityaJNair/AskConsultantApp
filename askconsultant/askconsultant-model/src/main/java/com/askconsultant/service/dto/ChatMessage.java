package com.askconsultant.service.dto;

/**
 * Chat message used in transfer of data between resource layer and model layer
 *
 */
public class ChatMessage {

	private long id;
	private String message;
	private String userid;
	private long conversationid;
	private String displayName;
	private String sentAt;
	private boolean isSenderSent;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public long getConversationid() {
		return conversationid;
	}

	public void setConversationid(long conversationid) {
		this.conversationid = conversationid;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getSentAt() {
		return sentAt;
	}

	public void setSentAt(String sentAt) {
		this.sentAt = sentAt;
	}

	public boolean isSenderSent() {
		return isSenderSent;
	}

	public void setSenderSent(boolean isSenderSent) {
		this.isSenderSent = isSenderSent;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
