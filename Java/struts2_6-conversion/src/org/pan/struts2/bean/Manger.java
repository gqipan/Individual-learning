package org.pan.struts2.bean;

import java.util.Date;

public class Manger {

	private Integer id;
	
	private String name;
	
	private Date birth;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Manger(Integer id, String name, Date birth) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
	}

	public Manger() {
		super();
	}

	@Override
	public String toString() {
		return "Manger [id=" + id + ", name=" + name + ", birth=" + birth + "]";
	}
	
	
	
}
