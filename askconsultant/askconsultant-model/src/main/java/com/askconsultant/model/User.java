package com.askconsultant.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	
	public User() {
		super();
	}

	@Id
	@Column(name="usertype_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	private String industry;
	private String interest;
	private String howDidYouKnow;
	private Date dob;
	private String gender;

	
	public User(String industry, String interest, String howDidYouKnow, Date dob, String gender){
		this.industry = industry;
		this.interest = interest;
		this.howDidYouKnow = howDidYouKnow;
		this.dob = dob;
		this.gender = gender;
	}
	
	public String getIndustry(){
		return industry;
	}
	
	public void setIndustry(String industry){
		this.industry = industry;
	}
	
	public String getInterest(){
		return interest;
	}
	
	public void setInterest(String interest){
		this.interest = interest;
	}

	public String getHow(){
		return howDidYouKnow;
	}
	
	public void setHow(String howDidYouKnow){
		this.howDidYouKnow = howDidYouKnow;
	}
	public String getGender(){
		return gender;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public Date getDOB(){
		return dob;
	}
	
	public void setDOB(Date dob){
		this.dob = dob;
	}
}
