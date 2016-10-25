package com.currency.convetor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	//declaration
	@Id
	@Column(name="idNumber",unique=true,length=13)
	private long idNumber;
	@Column(name="Name",length=25)
	private String name;
	@Column(name="SecondName",length=25)
	private String secondName;
	@Column(name="SurName",length=25)
	private String surName;
	@Column(name="Email",unique=true,length=45)
	private String email;
	@Column(name="Password",unique=true,length=15)
	private String password;
	//Contractors
	public User(){}
	public User(long idNumber, String name, String secondName, String surName,
			String email, String password) {
		super();
		this.idNumber = idNumber;
		this.name = name;
		this.secondName = secondName;
		this.surName = surName;
		this.email = email;
		this.password = password;
	}
	
	//setters
	public void setIdNumber(long idNumber) {this.idNumber = idNumber;}	
	public void setName(String name) {this.name = name;}	
	public void setSecondName(String secondName) {this.secondName = secondName;}	
	public void setSurName(String surName) {this.surName = surName;}	
	public void setEmail(String email) {this.email = email;}	
	public void setPassword(String password) {this.password = password;}
	
	//getters
	public long getIdNumber() {return idNumber;	}
	public String getName() {return name;}
	public String getSecondName() {return secondName;}
	public String getSurName() {return surName;}
	public String getEmail() {return email;}
	public String getPassword() {return password;}

}
