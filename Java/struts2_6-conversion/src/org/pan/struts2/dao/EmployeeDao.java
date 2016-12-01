package org.pan.struts2.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pan.struts2.bean.Employee;


public class EmployeeDao {
	
	//创建一个map，用来保存员工信息，key为员工的id 值为员工对象
	private static Map<Integer, Employee> map = new HashMap<Integer, Employee>();
	
	//创建一个员工的id
	private static int count = 0;
	
	//向map添加员工
	static{
		map.put(++count, new Employee(count, "孙悟空", 18, "保卫科", "科长"));
		map.put(++count, new Employee(count, "猪八戒", 28, "食堂", "试吃员"));
		map.put(++count, new Employee(count, "唐僧", 16, "取经事业部", "部长"));
		map.put(++count, new Employee(count, "沙僧", 38, "流沙河", "怪蜀黍"));
		map.put(++count, new Employee(count, "白龙马", 48, "运输部", "司机"));
	}
	
	/**
	 * 修改员工信息
	 * @param emp
	 */
	public void update(Employee emp){
		map.put(emp.getId(), emp);
	}
	
	/**
	 * 添加员工
	 * @param emp
	 */
	public void save(Employee emp){
		//为员工设置id
		emp.setId(++count);
		//将emp插入进数据库
		map.put(count, emp);
	}
	
	/**
	 * 根据id删除一个员工的信息
	 * @param id
	 */
	public void delete(int id){
		map.remove(id);
	}
	
	/**
	 * 根据id查找员工信息
	 * @param id
	 * @return
	 */
	public Employee getEmpById(int id){
		return map.get(id);
	}
	
	/**
	 * 获取所有的员工信息
	 * @return
	 */
	public List<Employee> getList(){
		
		return new ArrayList<Employee>(map.values());
	}
	
}
