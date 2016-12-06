package org.pan.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by QiPan on 2016/12/5.
 */
public class TestFormAction extends ActionSupport {

    @Setter@Getter
    private String username;

    public String testForm(){
        System.out.println(username);
        return SUCCESS;
    }

}
