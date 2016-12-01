package org.pan.struts2.conver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {

	private DateFormat format;

	public DateConverter() {
		format = new SimpleDateFormat("yy/MM/dd");
	}

	/**
	 * convertFromString这个方法在将一个请求参数转换为对象时调用
	 */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {

		System.out.println("我正在将字符串转换为对象");

		// 将请求参数转换为一个对象
		try {
			return format.parse(values[0]);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 将一个对象转换为字符串时调用
	 */
	@Override
	public String convertToString(Map context, Object o) {

		System.out.println("我正在对象转换为字符串");

		return format.format(o);
	}
}
