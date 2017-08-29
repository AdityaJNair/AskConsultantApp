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

	
	
	public Person() {
		super();
	}

	public Person(String firstName, String lastName, String prefName, String email, String password, Date dob, Date lastLogin, String status){
		this.firstName = firstName;
		this.lastName = lastName;
		this.prefName = prefName;
		this.email = email;
		this.password = password;
		this.lastLogin = lastLogin;
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
	private Date lastLogin;
	private String status;
	
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
	
	public Date getlastLogin(){
		return lastLogin;
	}
	
	public void setLastLogin(Date lastLogin){
		this.lastLogin = lastLogin;
	}	
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	
}
