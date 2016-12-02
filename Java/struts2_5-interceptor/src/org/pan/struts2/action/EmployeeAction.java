package org.pan.struts2.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.pan.struts2.bean.Employee;
import org.pan.struts2.dao.EmployeeDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

public class EmployeeAction extends ActionSupport implements RequestAware, ModelDriven<Employee>, Preparable {

	private Employee employee;

	private Integer id;

	private EmployeeDao employeeDao = new EmployeeDao();

	private Map<String, Object> request;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String list() {
		List<Employee> list = employeeDao.getList();
		request.put("list", list);
		return "list";
	}

	public String add() {
		employeeDao.save(employee);
		return SUCCESS;
	}
	
	/**
	 * 该方法会在add方法执行之前执行
	 * 也会在getModel方法执行之前执行，放到值栈栈顶中
	 */
	public void prepareDoAdd() {
		System.out.println("prepareDoAdd............");
		employee = new Employee();
	}

	public String del() {
		employeeDao.delete(employee.getId());
		return SUCCESS;
	}
	

	public String input() {
		return "input";
	}
	
	public void prepareInput() {
		System.out.println("prepareInput.........");
		employee = employeeDao.getEmpById(id);
	}

	public String update() {
		employeeDao.update(employee);
		return SUCCESS;
	}
	
	/**
	 * 在update方法之前，初始化employ,然后由 getModel 方法放到栈顶
	 */
	public void prepareUpdate() {
		System.out.println("prepareUpdate..............");
		employee = new Employee();
	}

	@Override
	public Employee getModel() {
		System.out.println("getModel。。。。。。。。。。。");
		
	
		
		return employee;
	}

	/**
	 * 该方法中，可以做一些统一的处理
	 */
	@Override
	public void prepare() throws Exception {
		
		System.out.println("prepare..................");
		
		/*
		 *  例如：对于 delete 方法，虽然该方法只需要使用 id， 
		 *  	但是我们调用该方法之前，调用 getModel() 返回的是个 null
		 *  	所以我们可以在这 做一次判断
		 */
		if (employee == null) {
			employee = new Employee();
		}
	}

}
