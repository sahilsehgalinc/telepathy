/**
 * COMPASS. 
 * Copyright © 2015 COMPASS. 
 * 
 * All rights reserved.
 * 
 * THIS PRODUCT CONTAINS CONFIDENTIAL INFORMATION  OF COMPASS. 
 * USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED WITHOUT THE 
 * PRIOR EXPRESS WRITTEN PERMISSION OF COMPASS.
 */
package com.compass.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * The persistent class for the email_logging database table.
 * 
 */
@Entity @org.hibernate.annotations.Entity(dynamicInsert = true)
@Table(name="email_logging")
@Cache(region = "emailLogging", usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name="EmailLogging.findAll", query="SELECT e FROM EmailLogging e")
public class EmailLogging implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	private String discription;

	private String purpose;

	@Column(name="RECIEVER_EMAIL")
	private String recieverEmail;

	@Column(name="SENDER_EMAIL")
	private String senderEmail;

	public EmailLogging() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getRecieverEmail() {
		return this.recieverEmail;
	}

	public void setRecieverEmail(String recieverEmail) {
		this.recieverEmail = recieverEmail;
	}

	public String getSenderEmail() {
		return this.senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

}