package org.pan.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.pan.springmvc.dao.DepartmentDao;
import org.pan.springmvc.dao.EmployeeDao;
import org.pan.springmvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/testRestFul")
public class RestFulController {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao;

	@RequestMapping(value = "/emps", method = RequestMethod.GET)
	public String queryList(Map<String, Object> map) {
		System.out.println("==================> Multi Interceptor Biz Method........... ");
		map.put("employees", employeeDao.getAll());
		return "list";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String inputEmployee(Map<String, Object> map) {
		// 1 查询出全部部门；
		map.put("departments", departmentDao.getDepartments());
		map.put("genders", getGenderUtils());
		map.put("employee", new Employee());
		return "input";
	}

//	@RequestMapping(value = "/emp", method = RequestMethod.POST)
//	public String saveEmployee(Employee employee) {
//		
//		System.out.println(" Save Employee :" + employee.toString());
//		
//		employeeDao.save(employee);
//		return "redirect:/testRestFul/emps";
//	}
	
	/**
	 * JSR303验证：
	 * 	
	 */
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult bindingResult, Map<String, Object> map) {
		
		if (bindingResult != null && bindingResult.getFieldErrorCount() > 0) {
			 List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				System.out.println(fieldError.getField() + "\t" + fieldError.getCode());
			}
//			throw new RuntimeException("录入信息出错");
			//出错后跳转到Input 页面, 这些出错信息会自动的放入到Map中
			map.put("departments", departmentDao.getDepartments());
			map.put("genders", getGenderUtils());
			return "input";
		}
		
		System.out.println(" Save Employee :" + employee.toString());
		
		employeeDao.save(employee);
		return "redirect:/testRestFul/emps";
	}

	@RequestMapping(value = "/emp/{id}")
	public String toUpdate(Map<String, Object> map, @PathVariable(value = "id") Integer id) {

		// 1 查询出全部部门；
		map.put("departments", departmentDao.getDepartments());
		
		// 2 查询出性别，也保存进LOV (list of value)；
		map.put("genders", getGenderUtils());
		// 3 新建承载的bean，实现和前台form表单的对应
		map.put("employee", employeeDao.get(id));

		return "edit";
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.PUT)
	public String update(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/testRestFul/emps";
	}

	@ModelAttribute
	public void getEmployeeById(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {

		if (id != null) {
			Employee employee = employeeDao.get(id);
			map.put("employee", employee);
		}
	}
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/testRestFul/emps";
	}

	// =========模拟从LOV数据库查询出gender值
	public Map<String, String> getGenderUtils() {
		Map<String, String> genders = new HashMap<String, String>();
		// 1 male, 0 female
		genders.put("1", "male");
		genders.put("0", "female");

		return genders;
	}
	
	//========员工类型转换,String--Convert-->Employee
	@RequestMapping(value="/empConvert",method=RequestMethod.POST)
	public String empConvert(@RequestParam("employee") Employee employee) {
		
		employeeDao.save(employee);
		return "redirect:/testRestFul/emps";
	}
	
	/**
	 * 可以在前台页面到Binder 之间做一些操作
	 * InitBinder 方法返回值必须是 void
	 * 参数通常是 WebDataBinder
	 * @param webDataBinder
	 */
//	@InitBinder
//	public void initBinder(WebDataBinder webDataBinder) {
//		//不再对  email 字段进行绑定
//		webDataBinder.setDisallowedFields("email");
//	}

	
	@RequestMapping(value = "/testExceptionHandlerExceptionResolver", method = RequestMethod.GET)
	public String testExceptionHandlerExceptionResolver(@RequestParam(value = "age") Integer age){
		
		System.out.println("Test testExceptionHandlerExceptionResolver .............");
		
		System.out.println(10 / age);
		
		return "ok";
	}
}
