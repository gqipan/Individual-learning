package org.pan.struts.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by PanPan on 2016/12/4.
 */
public class MyInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation invocation) throws Exception {

        System.out.println("before invocation.invoke...");
        String result = invocation.invoke();
        System.out.println("after invocation.invoke...");
        return result;
        //return "success";直接返回一个具体的值不会调用后面的拦截器
    }
}
