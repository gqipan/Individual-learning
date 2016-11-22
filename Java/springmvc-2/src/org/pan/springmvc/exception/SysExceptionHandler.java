package org.pan.springmvc.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 使用AOP的方式，使得异常处理和普通的 Handler 方法分离
 * 	如果Handel找不到 @ExceptionHandler 方法的话，就会来标记了@ControllerAdvice方法中找标记了@ExceptionHandler的对应的异常
 */
@ControllerAdvice
public class SysExceptionHandler {

	@ExceptionHandler(value = {ArithmeticException.class})
	public ModelAndView dealExceptionHandle(Exception e) {
		System.out.println("====@ControllerAdvice===========>" + e.getMessage());
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("exception", e);
		return modelAndView;
	}

}
