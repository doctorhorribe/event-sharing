package com.eventsharing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userID;
	
	@Column(name="FIRST_NAME")
	private String fisrtName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="EMAIL")
	private String email;
	
}
