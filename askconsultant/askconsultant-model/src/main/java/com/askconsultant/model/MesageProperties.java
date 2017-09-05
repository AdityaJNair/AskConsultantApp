package com.askconsultant.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MessageProperties
 *
 */
@Table(name="messageproperties")

public class MesageProperties implements Serializable {

	
	private long id;
	private long messageid;
	private String name;
	private String value;
	private static final long serialVersionUID = 1L;

	public MesageProperties() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public long getMessageid() {
		return this.messageid;
	}

	public void setMessageid(long messageid) {
		this.messageid = messageid;
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
