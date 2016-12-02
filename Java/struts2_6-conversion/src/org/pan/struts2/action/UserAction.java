package org.pan.struts2.action;

import java.util.List;

import org.pan.struts2.bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private User user;

	private List<User> users;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


	public String addUser() {
		System.out.println(user);
		return "success";
	}
	
	public String addUsers() {
		System.out.println(users);
		return "success";
	}

}
