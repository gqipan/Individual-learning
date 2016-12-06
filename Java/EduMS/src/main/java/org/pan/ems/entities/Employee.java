package org.pan.ems.entities;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Employee {

	// id
	private Integer employeeId;
	// 登录名
	private String loginName;

	// 员工名称
	private String employeeName;
	// 密码
	private String password;

	// 角色集合
	private Set<Role> roles = new HashSet<Role>();
	// 用户是否可用. 1 代表可用, 0 代表不可用
	private Integer enabled;
	
	// 所属部门
	private Department department;
	// 生日
	private Date birth;
	
	// 性别
	private String gender;
	// Email
	private String email;
	
	// 电话
	private String mobilePhone;
	// 访问次数
	private int visitedTimes;
	
	// 是否被删除. 1 代表已经被删除, 0 代表没有被删除
	private int isDeleted;
	// 简历
	private Resume resume;
	
	// 录入人
	private Employee editor;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String loginName, String employeeName, String password,
			Set<Role> roles, Integer enabled, Department department,
			String gender, String email, int visitedTimes) {
		super();
		this.loginName = loginName;
		this.employeeName = employeeName;
		this.password = password;
		this.roles = roles;
		this.enabled = enabled;
		this.department = department;
		this.gender = gender;
		this.email = email;
		this.visitedTimes = visitedTimes;
	}



	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		//去除传入的参数的前后空格.
//		if(loginName != null){
//			loginName = loginName.trim();
//		}
		this.loginName = loginName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public int getVisitedTimes() {
		return visitedTimes;
	}

	public void setVisitedTimes(int visitedTimes) {
		this.visitedTimes = visitedTimes;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Employee getEditor() {
		return editor;
	}

	public void setEditor(Employee editor) {
		this.editor = editor;
	}
	
	//工具方法, 返回 role 的 name 的字符串. 若有多个 Role, 则 Role 的 name 使用 , 分割
	public String getRoleNames(){
		List<String> roleNames = new ArrayList<String>();
		for(Role role: roles){
			roleNames.add(role.getRoleName());
		}
		
		return StringUtils.join(roleNames, ",");
	}
	
	//工具方法: 用于 Ajax 返回 departmentName
	public String getDepartmentName(){
		return department.getDepartmentName();
	}
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	//工具方法: 用于 Ajax 返回 birth
	public String getDisplayBirth(){
		if(this.birth == null){
			return "";
		}
		
		return dateFormat.format(birth);
	}
	
	//工具方法: 接受服务端的 Stirng[] 数组, 并把其转为 Role 的集合
	public void setRoles2(String [] roleIds){
		if(roleIds != null && roleIds.length > 0){
			for(String roleId: roleIds){
				Integer id;
				try {
					id = Integer.parseInt(roleId);
					Role role = new Role(id);
					this.roles.add(role);
				} catch (NumberFormatException e) {}
			}
		}
	}
	
	//工具方法: 用于表单的回显. 把 Role 的集合转为 String[]
	public List<String> getRoles2(){
		List<String> ids = new ArrayList<String>();
		
		for(Role role: this.roles){
			ids.add(role.getRoleId() + "");
		}
		
		return ids;
	}

}
