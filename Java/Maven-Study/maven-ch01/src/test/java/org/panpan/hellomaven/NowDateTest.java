package org.panpan.hellomaven;

import org.junit.*;
import java.util.Date;
import org.panpan.hellomaven.NowDate;

public class NowDateTest{
	@Test
	public void getNowDateStrTest(){
		NowDate nd = new NowDate();
		String resultStr = nd.getNowDateStr();
		System.out.println(resultStr);
	}
}
