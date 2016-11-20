package org.pan.springmvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Test01
{
	@RequestMapping(value="/testInit",method=RequestMethod.GET)
	public String testInit()
	{
		return "ok";
	}
}
