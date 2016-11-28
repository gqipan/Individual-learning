package org.pan.struts2.entities;

public class User {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username) {
		super();
		this.username = username;
	}

}
