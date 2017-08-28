package com.askconsultant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserType")
public class UserType {
	@Id
	@Column(name="usertype_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}

class User extends UserType{
	private String industry;
	private String interest;
	private String howDidYouKnow;
	
	public User(String industry, String interest, String howDidYouKnow){
		this.industry = industry;
		this.interest = interest;
		this.howDidYouKnow = howDidYouKnow;
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
}

class Employee extends UserType{
	
}