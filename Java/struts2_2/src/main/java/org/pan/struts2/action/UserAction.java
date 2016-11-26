package org.pan.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ognl.OgnlValueStack;
import com.opensymphony.xwork2.util.ValueStack;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.interceptor.HttpParametersAware;
import org.pan.struts2.entity.User;

/**
 * Created by Pan on 2016/11/26.
 */
public class UserAction extends ActionSupport implements HttpParametersAware{

    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private Integer age;
    @Setter
    @Getter
    private String address;


    private HttpParameters parameters;
    public void setParameters(HttpParameters parameters) {
        this.parameters = parameters;
    }

    public String hello (){
        System.out.println("UserAction-hello...........");
        return SUCCESS;
    }

    public String input(){
        System.out.println("To user Input.............");
        return INPUT;
    }

    public String addUser (){
        System.out.println("UserAction-Add， Before Update...........");
        System.out.println(username + " -" + age + "_" +address);

        //改变对象栈，栈顶的对象
        ActionContext context = ActionContext.getContext();
        ValueStack valueStack = context.getValueStack();
        valueStack.push(User.builder().username("猪八戒").title("巨无霸").address("高老庄").build());

        return SUCCESS;
    }

    public String testException(){

        int result = 10 /0;

        System.out.println("Test ExceptionMapping...........");

        return "exception";
    }


}
