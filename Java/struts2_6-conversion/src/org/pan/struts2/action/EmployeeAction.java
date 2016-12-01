package org.pan.struts2.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.pan.struts2.bean.Employee;
import org.pan.struts2.dao.EmployeeDao;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction extends ActionSupport implements RequestAware , ModelDriven<Employee> , Preparable {

	// 创建一个Dao对象
	private EmployeeDao dao = new EmployeeDao();

	/**
	 * list查询所有的员工的信息，并放到request域中
	 * @return
	 */
	public String list() {
		// 返回所有的员工的列表
		List<Employee> list = dao.getList();

		// 将list放入进request域中
		request.put("list", list);

		// 返回
		return "list";
	}

	/**
	 * 根据员工的id删除一个员工的信息
	 * @return
	 */
	public String del() {

		dao.delete(id);

		return "success";

	}
	
	/**
	 * 该方法会在add方法执行之前执行
	 * 也会在getModel方法执行之前执行
	 */
	public void prepareAdd(){
		employee = new Employee();
	}
	
	public void prepareUpdate(){
		employee = new Employee();
	}
	
	/**
	 * 向数据库中添加一个员工
	 * @return
	 */
	public String add() {

		System.out.println(employee);
		// 将用户存入数据库
		dao.save(employee);

		return "success";
	}
	
	//这个方法会在input方法执行前执行，会从数据库读取一个Employee对象
	public void prepareInput(){
		
		employee = dao.getEmpById(id);
	}

	//修改员工之前，查询员工信息，并跳转到修改页面
	public String input() {
		return "input";
	}
	
	

	/**
	 * 更新员工的信息
	 * @return
	 */
	public String update() {

		// 更新数据
		dao.update(employee);

		return "success";

	}
	
	private Integer id;
	
	private Employee employee;

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public Employee getModel() {
		
		return employee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void prepare() throws Exception {
		System.out.println("prepare...");
		
	}

}
