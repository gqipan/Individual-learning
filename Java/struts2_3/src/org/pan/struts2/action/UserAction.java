package org.pan.struts2.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	@SuppressWarnings("unchecked")
	public String testTag() {

		// 获取ActionContext对象
		ActionContext context = ActionContext.getContext();
		// 获取session的map
		Map<String, Object> session = context.getSession();
		// 向session中添加一个属性
		session.put("username", "猪八戒");
		// 直接向map栈中放入一个username属性
		context.put("username", "猪悟能");
		
		
		this.username = "tom";
		
		
		Map<String, Object> request = (Map<String, Object>) context.get("request");
		
		// set Request域中对象
		request.put("username", "孙悟空");

		return "success";
	}

}
