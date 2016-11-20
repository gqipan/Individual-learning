package org.pan.springmvc.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pan.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
// @SessionAttributes(value = "user")
//@SessionAttributes(types = { String.class }) // 也可以使用 type 来定义
public class TestController {

	@RequestMapping(value = "/testRequestHeaderHost", method = RequestMethod.GET)
	public String testRequestHeaderHost(@RequestHeader("Host") String host) {

		System.out.println("-----testRequestHeader: " + host);
		return "ok";
	}

	@RequestMapping(value = "/testRequestHeader", method = RequestMethod.GET)
	public String testRequestHeader(@RequestHeader(value = "User-Agent") String UserAgent) {

		System.out.println("================testRequestHeader:" + UserAgent);

		return "ok";
	}

	@RequestMapping(value = "/testCookieValue", method = RequestMethod.GET)
	public String testCookinValue(@CookieValue("JSESSIONID") String JSESSIONID) {

		System.out.println("===============testCookieValue: JSESSIONID" + JSESSIONID);
		return "ok";
	}

	/**
	 * 
	 * @param bookId
	 * @return
	 */
	@RequestMapping(value = "/testPathVariable/{bookId}", method = RequestMethod.GET)
	public String testPathVariable(@PathVariable("bookId") String bookId) {

		System.out.println("-----testPathVariable: " + bookId);
		return "ok";
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String testRestful_Post() {

		System.out.println("-----testRestful_Post: ");
		return "ok";
	}

	/**
	 * Restful DELETE请求
	 * 
	 * @param ordId
	 * @return
	 */
	@RequestMapping(value = "/order/{ordId}", method = RequestMethod.DELETE)
	public String testRestful_Delete(@PathVariable("ordId") String ordId) {

		System.out.println("-----testRestful_Delete: " + ordId);
		return "ok";
	}

	/**
	 * Restful PUT请求
	 * 
	 * @param ordId
	 * @return
	 */
	@RequestMapping(value = "/order/{ordId}", method = RequestMethod.PUT)
	public String testRestful_Put(@PathVariable("ordId") String ordId) {
		System.out.println("-----testRestful_Put: " + ordId);
		return "ok";
	}

	@RequestMapping(value = "/testRequestParam")
	public String testRequestParam(@RequestParam(value = "age", required = true, defaultValue = "300") Integer age,
			@RequestParam("roldId") List<Integer> roldIds) {

		System.out.println("-----testRequestParam: " + age);
		for (Integer roldId : roldIds) {
			System.out.println(roldId);
		}
		return "ok";
	}

	@RequestMapping(value = "testServletAPI", method = RequestMethod.GET)
	public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("utf-8");
		System.out.println("-----HttpServletRequest: " + request.getContextPath());
		System.out.println("-----HttpServletRequest: " + response.getCharacterEncoding());
		return "ok";
	}

	@RequestMapping(value = "testModelAndView", method = RequestMethod.GET)
	public ModelAndView testModelAndView() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("myModelAndView", new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		mv.setViewName("ok");

		return mv;
	}

	@RequestMapping(value = "testMap_Model_ModelMap", method = RequestMethod.GET)
	public String testMap_Model_ModelMap(Map<String, Object> m1, Model m2, ModelMap m3) {

		m1.put("m1", "java.util.Map<String, Object>");
		m2.addAttribute("m2", "org.springframework.ui.Model");
		m3.addAttribute("m3", "org.springframework.ui.ModelMap");

		System.out.println(m1 == m2);
		System.out.println(m2 == m3);

		System.out.println(m1 == m3);

		System.out.println(m1.getClass().getName());
		System.out.println(m2.getClass().getName());
		System.out.println(m3.getClass().getName());

		return "ok";
	}

	@RequestMapping(value = "/testSessionAttributes", method = RequestMethod.GET)
	public String testSessionAttributes(Map<String, Object> map) {
		User user = new User(11, "z3", "123456", 17, "z3@163.com");
		map.put("user", user);

		map.put("subway", "line6##############");
		return "ok";
	}

	@RequestMapping(value = "/testModelAttribute", method = RequestMethod.PUT)
	public String testModelAttribute(@ModelAttribute("xxx") User user) {
		System.out.println("from front page: " + user.toString());
		return "ok";
	}

	@ModelAttribute
	public void getUserById(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
		System.out.println("come in @ModelAttribute*************");
		if (null != id) {
			// 模拟根据id从数据库查询出来对应的User信息
			// User user = UserService.getUserById(id);
			User user = new User(11, "lisi", "123456", 26, "lisi@163.com");

			map.put("user", user);
			System.out.println("from mysql DB:" + user.toString());
		}
	}
	
	//testJSTLView
	@RequestMapping(value="/testJSTLView",method=RequestMethod.GET)				
	public String testJSTLView()
	{
		System.out.println("-----testJSTLView");
		return "ok";
	}	

	@RequestMapping(value="/testMyHelloView",method=RequestMethod.GET)				
	public String testHelloView()
	{
		System.out.println("-----testMyHelloView");
		//返回自定义View视图
		return "myHelloView";
	}
	@RequestMapping(value="/testRedirect",method=RequestMethod.GET)				
	public String testRedirect()
	{
		System.out.println("-----testRedirect");
		
		return "redirect:/1.jsp";
	}	

	@RequestMapping(value="/testForward",method=RequestMethod.GET)				
	public String testForward()
	{
		System.out.println("-----testForward");
		return "forward:/2.jsp";
	}	
}
