package org.pan.springmvc.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

@Component
public class MyHelloView implements View{

	@Override
	public String getContentType() {
		return "text/html; charset=UTF-8";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write("Hello My View");
		response.getWriter().flush();
		response.getWriter().close();
	}

}
