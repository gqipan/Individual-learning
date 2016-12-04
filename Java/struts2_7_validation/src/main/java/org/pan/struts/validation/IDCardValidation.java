package org.pan.struts.validation;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;
import org.pan.struts.pojo.IDCard;

/**
 * Created by PanPan on 2016/12/4.
 */
public class IDCardValidation extends FieldValidatorSupport {


    public void validate(Object object) throws ValidationException {

        //1、获取字段名称
        String fieldName = getFieldName();
        //2、获取值
        Object value = this.getFieldValue(fieldName, object);

        //3、验证
        IDCard idCard = new IDCard();
        boolean result =  idCard.Verify(value.toString());

        //4、验证失败加入错误消息
        if (!result) {
            addFieldError(fieldName, object);
        }

    }



}
