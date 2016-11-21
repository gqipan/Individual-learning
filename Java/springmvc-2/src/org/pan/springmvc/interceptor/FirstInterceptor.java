package org.pan.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义拦截器
 * @author QiPan
 *
 */
@Component
public class FirstInterceptor implements HandlerInterceptor {

	
	/**
	 * DispathcherServlet 业务方法处理请求之前调用，如果返回 false 不再调用后续的拦截器
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {

		System.out.println("FirstInterceptor.preHandle..............");
		
		return true;
	}

	/**
	 * DispathcherServlet 业务方法处理请求之后，响应之前调用 
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("FirstInterceptor.postHandle..............");
	}

	/**
	 * DispathcherServlet 完全处理完请求后调用
	 * 如果是 preHandle 方法返回 false 也会触发该方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("FirstInterceptor.afterCompletion..............");

	}
	

}
