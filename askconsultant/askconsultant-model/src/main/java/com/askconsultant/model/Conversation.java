package com.askconsultant.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Conversation
 *
 */
@Entity
@Table(name="conversation")

public class Conversation implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String owner;
	private Timestamp createdatetime;
	private String name;
	private String status;
	private String archivinguser;
	private String category;
	private static final long serialVersionUID = 1L;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Conversation() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}   
	public Timestamp getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Timestamp createdatetime) {
		this.createdatetime = createdatetime;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getArchivinguser() {
		return archivinguser;
	}
	public void setArchivinguser(String archivinguser) {
		this.archivinguser = archivinguser;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
   
}
