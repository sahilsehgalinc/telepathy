
package com.compass.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the login_tracking database table.
 * 
 */
@Entity
@Table(name="login_tracking")
@NamedQuery(name="LoginTracking.findAll", query="SELECT l FROM LoginTracking l")
public class LoginTracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="CREATED_DATE")
	private Timestamp createdDate;

	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="WEB_BROWSER")
	private String webBrowser;
	
	@Column(name="FLAG")
	private String flag;
	
	private String email;

	private String ip;

	private String password;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LoginTracking() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWebBrowser() {
		return this.webBrowser;
	}

	public void setWebBrowser(String webBrowser) {
		this.webBrowser = webBrowser;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
}