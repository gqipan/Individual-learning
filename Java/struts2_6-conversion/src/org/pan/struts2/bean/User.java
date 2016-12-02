package org.pan.struts2.bean;

public class User {

	private String name;
	private String gender;
	private String address;

	private Manger mgr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Manger getMgr() {
		return mgr;
	}

	public void setMgr(Manger mgr) {
		this.mgr = mgr;
	}

	public User(String name, String gender, String address, Manger mgr) {
		super();
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.mgr = mgr;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", address=" + address + ", mgr=" + mgr + "]";
	}

}
