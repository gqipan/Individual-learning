package org.panpan.hellomaven;

import org.panpan.util.DateUtil;
import java.util.Date;

public class NowDate{
	
	public String getNowDateStr(){
		String nowDateStr = DateUtil.DateToString(new Date());
		return nowDateStr;
	}
}
