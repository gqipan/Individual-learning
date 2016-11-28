package org.pan.struts2.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.pan.struts2.bean.Employee;
import org.pan.struts2.dao.EmployeeDao;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport implements RequestAware {

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
	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}


	private EmployeeDao employeeDao = new EmployeeDao();

	public String list() {
		List<Employee> list = employeeDao.getList();
		request.put("list", list);
		return "list";
	}

	public String add() {

		Employee emp = new Employee(null, name, age, dept, role);
		employeeDao.save(emp);

		return SUCCESS;
	}

	public String del() {

		employeeDao.delete(id);

		return SUCCESS;
	}
	
	
	public String input() {
		
		Employee employee = employeeDao.getEmpById(id);
		this.id = employee.getId();
		this.name = employee.getName();
		this.age = employee.getAge();
		this.dept = employee.getDept();
		this.role = employee.getRole();
		return "input";
	}
	
	public String update() {
		
		Employee employee = new Employee(id, name, age, dept, role);
		employeeDao.update(employee);
		return SUCCESS;
	}

	
}
