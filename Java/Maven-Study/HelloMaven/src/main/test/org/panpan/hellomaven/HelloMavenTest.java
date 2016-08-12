package org.panpan.hellomaven;

import org.junit.*


public class HelloMavenTest{

	@Test
	public void testSayHello(){
		HelloMaven hm = new HelloMaven();
		String resultStr = hm.sayHello();
		System.out.println(resultStr);
		assertEquals(resultStr,"Hello Maven!");
	}

}
