package org.pan.springmvc.contvert;

import org.pan.springmvc.entity.Department;
import org.pan.springmvc.entity.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 自定义类型转换器
 * 
 * @author PanPan
 */
@Component(value = "employeeConvert")
public class EmployeeConvert implements Converter<String, Employee> {

	@Override
	public Employee convert(String source) {
		Employee employee = null;
		if (source == null) {
			return employee;
		}

		String[] fileds = source.split(";");

		if (fileds == null || fileds.length != 4) {
			return employee;
		}

		employee = new Employee();
		employee.setLastName(fileds[0]);
		employee.setEmail(fileds[1]);
		employee.setGender(Integer.parseInt(fileds[2]));
	
		Department department = new Department();
		department.setId(Integer.parseInt(fileds[3]));
		employee.setDepartment(department);
	
		return employee;
	}

}
