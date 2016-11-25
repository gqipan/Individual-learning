package org.pan.struts2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 方式二： 实现 ServletXxxxAware 接口的方式
 */
public class ServletAPITest extends ActionSupport implements ServletRequestAware, ServletContextAware, ServletResponseAware{

    private HttpServletRequest request;
    private ServletContext context;
    private HttpServletResponse response;
    private HttpSession session;


    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setServletContext(ServletContext context) {
        this.context = context;
    }

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * Session 比较特殊，我们可以在用的时候通过 request 来获取
     */
    private void testGetSession(){
        if (request != null){
            session = request.getSession();
        }
    }

    /**
     * 方式一： 通过 org.apache.struts2.ServletActionContext 的静态方法来获取这些原生的 ServletAPI
     * @return
     */
    public String testServletAPI_ServletActionContext(){

        ActionContext context = ServletActionContext.getContext();
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        //Session 可以通过 request 来获取
        HttpSession session = request.getSession();

        return SUCCESS;
    }
}
