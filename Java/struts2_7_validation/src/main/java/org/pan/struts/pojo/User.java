package org.pan.struts.pojo;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by PanPan on 2016/12/3.
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private String userName;


    private Integer age;

    private String password;


    public String getUserName() {
        return userName;
    }

    public Integer getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
