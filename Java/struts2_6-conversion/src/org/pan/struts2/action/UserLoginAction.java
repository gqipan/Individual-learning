package org.pan.struts2.action;

import java.util.Arrays;

import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport{

	public String execute(){
		
		String submit = getText("submit");
		String username = getText("username");
		String password = getText("password");
		
		System.out.println(username + "_" + password + "_" + submit);
		
		String info = getText("info", Arrays.asList("大师兄","小师妹") );
		
		//当需要替换信息中的占位符时，需要传一个String的集合
		System.out.println(info);
		
		return "success";
		
	}
}
