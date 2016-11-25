package org.pan.struts2.action;

public class HelloAction {
	
	public String execute(){
		
		System.out.println("Hello Struts");
		
		return "success";
	}
	
	public String add(){
		
		System.out.println("我是HelloAction的add方法！");
		
		return "success";
		
	}
	
	public String update(){
		
		System.out.println("update方法被调用");
		
		return "success";
		
	}

}
