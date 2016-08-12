package org.panpan.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil{

	public static String DateToString(Date date){
		if (null == date) {
			return "";
		}
		try{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:dd:mm");
			return df.format(date);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}

}
