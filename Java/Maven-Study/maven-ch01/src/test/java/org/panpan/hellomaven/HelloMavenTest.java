package org.panpan.hellomaven;

import org.junit.*;
import org.panpan.hellomaven.HelloMaven;


public class HelloMavenTest{

	@Test
	public void testSayHello(){
		HelloMaven hm = new HelloMaven();
		String resultStr = hm.sayHello();
		System.out.println(resultStr);
		Assert.assertEquals(resultStr,"Hello Maven!");
	}

}
