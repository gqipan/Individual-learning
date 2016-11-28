package org.pan.struts2.bean;

public class Employee {

	private Integer id;
	private String name;
	private Integer age;
	// 部门
	private String dept;
	// 角色
	private String role;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Employee(Integer id, String name, Integer age, String dept,
			String role) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.role = role;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", dept=" + dept + ", role=" + role + "]";
	}

}
