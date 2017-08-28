package com.askconsultant.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	public enum Gender{Male,Female,Other,Null}
	public enum Status{Active,Inactive,Blacklist}

	public Person(String firstName, String lastName, String prefName, String email, String password, Date dob, Date lastLogin, Gender gender, Status status, UserType userType){
		this.firstName = firstName;
		this.lastName = lastName;
		this.prefName = prefName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.lastLogin = lastLogin;
		this.gender = gender;
		this.status = status;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String prefName;
	private String email;
	private String password;
	private Date dob;
	private Date lastLogin;
	private Gender gender;
	private Status status;
	private UserType userType;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getPrefName(){
		return prefName;
	}
	
	public void setPrefName(String prefName){
		this.prefName = prefName;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public Date getDOB(){
		return dob;
	}
	
	public void setDOB(Date dob){
		this.dob = dob;
	}
	
	public Date getlastLogin(){
		return lastLogin;
	}
	
	public void setLastLogin(Date lastLogin){
		this.lastLogin = lastLogin;
	}	
	
	public Gender getGender(){
		return gender;
	}
	
	public void setGender(Gender gender){
		this.gender = gender;
	}
	
	public Status getStatus(){
		return status;
	}
	
	public void setStatus(Status status){
		this.status = status;
	}
	
	public UserType getUserType(){
		return userType;
	}

	public void setUserType(UserType userType){
		this.userType = userType;
	}
}
