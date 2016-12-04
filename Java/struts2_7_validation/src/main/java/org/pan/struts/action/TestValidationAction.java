package org.pan.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.pan.struts.pojo.User;

/**
 * Created by PanPan on 2016/12/3.
 */
public class TestValidationAction extends ActionSupport implements ModelDriven<User>, Preparable {

    private User user;

    /**
     * 跳过校验
     */
    @SkipValidation
    public String input(){
        return INPUT;
    }

    @Validations(
            intRangeFields = { @IntRangeFieldValidator(type = ValidatorType.SIMPLE,
                    fieldName = "user.age",
                    min = "20", max = "60",
                    message = "年龄必须在 ${min} and ${max}")},
            requiredFields = {@RequiredFieldValidator(type = ValidatorType.SIMPLE,
                    fieldName = "user.userName",
                    message = "请输入用户名")},
            requiredStrings = {@RequiredStringValidator(type = ValidatorType.SIMPLE,
                    fieldName = "user.password",
                    message = "密码必须为全字符")}
    )
    public String register(){
        System.out.println("User..."+user);
        return SUCCESS;
    }

    public User getModel() {
        return user;
    }

    public void prepare() throws Exception {
        if (user == null){
            user = new User();
        }
    }

    @Override
    public void validate(){

    }
}
