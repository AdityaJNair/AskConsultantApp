package com.askconsultant.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ConversationProperties
 *
 */
@Entity
@Table(name="conversationproperties")

public class ConversationProperties implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long conversationid;
	private String name;
	private String value;
	private static final long serialVersionUID = 1L;

	public ConversationProperties() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public long getConversationid() {
		return this.conversationid;
	}

	public void setConversationid(long conversationid) {
		this.conversationid = conversationid;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
   
}
