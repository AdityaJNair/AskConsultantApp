package com.askconsultant.model;

import java.io.Serializable;
import java.lang.String;
import java.sql.Blob;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Attachment
 *
 */
@Entity
@Table(name="attachment")

public class Attachment implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Blob attachment;
	private String type;
	private static final long serialVersionUID = 1L;

	public Attachment() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public Blob getAttachment() {
		return this.attachment;
	}

	public void setAttachment(Blob attachment) {
		this.attachment = attachment;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
