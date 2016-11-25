package org.pan.struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.HttpParametersAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * 方式二： 实现 XxxxAware 的接口的方式来 Set 各种解耦的ServletAPI
 */
public class UserAction  implements ApplicationAware, SessionAware, RequestAware, HttpParametersAware {

    /**
     * 方式二可以在多个方法中公用这些 ServletAPI
     */
    private Map<String, Object> application;
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }

    private HttpParameters parameters;
    public void setParameters(HttpParameters parameters) {
        this.parameters = parameters;
    }

    private Map<String, Object> request;
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    private Map<String, Object> session;
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 方式一： 通过 ActionContext 的方式获取解耦的 ServletAPI
     *
     * @return
     */
    public String getServletAPI_ActionContext() {

        //与Servlet 解耦的方式获取 Struts2 封装的 API
        ActionContext actionContext = ActionContext.getContext();

        Map<String, Object> session = actionContext.getSession();
        //注意session的真实类型是SessionMap，它的内部保存一个Session对象
        //可以通过该对象invalidate方法来使session失效
        SessionMap sessionMap = (SessionMap) session;
        sessionMap.invalidate();


        Map<String, Object> application = actionContext.getApplication();

        // requestMap 获取比较特殊，使用get 方法获取
        Map<String, Object> request = (Map<String, Object>) actionContext.get("request");

        HttpParameters parameters = actionContext.getParameters();
        Map<String, String[]> parametersMap = parameters.toMap();

        session.put("seeesionKey", "sessionValue");
        application.put("applicationKey", "applicationValue");
        request.put("applicationKey", "applicationValue");
        parametersMap.put("parametersMapKey", new String[]{"parametersMapValue"});

        return "success";
    }

    public String helloWorld(){
        System.out.println("UserAction#helloWorld 被调用...........");
        return "success";
    }

}
