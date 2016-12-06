package org.pan.ems.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	//id
	private Integer departmentId;
	//部门名称
	private String departmentName;
	
	//部门经理
	private Employee manager;
	//员工
	private Set<Employee> employees = new HashSet<Employee>();
}
