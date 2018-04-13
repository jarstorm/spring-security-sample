package com.minds.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity.
 */
@Entity
@Table(name = "MINDS_USER")
public class CustomUser implements Serializable {

	/**
	 * Serial version UUID.
	 */
	private static final long serialVersionUID = 6345527571719641878L;

	/**
	 * User name.
	 */
	@Id
	@Column(name = "USER_NAME")	
	private String username;

	/**
	 * User password.
	 */
	@Column(name = "USER_PASSWORD")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
