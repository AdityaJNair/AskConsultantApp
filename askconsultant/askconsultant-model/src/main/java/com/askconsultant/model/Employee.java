package com.askconsultant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee Entity that holds employee information
 *
 */
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 50)
	private String userid;

	@Column(nullable = false, length = 50)
	private String password;

	@Column(nullable = false, length = 50)
	private String role;

	@Column(nullable = false, length = 50)
	private String primaryTopic;

	@Column(nullable = false, length = 50)
	private String primarySubTopic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPrimaryTopic() {
		return primaryTopic;
	}

	public void setPrimaryTopic(String primaryTopic) {
		this.primaryTopic = primaryTopic;
	}

	public String getPrimarySubTopic() {
		return primarySubTopic;
	}

	public void setPrimarySubTopic(String primarySubTopic) {
		this.primarySubTopic = primarySubTopic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
