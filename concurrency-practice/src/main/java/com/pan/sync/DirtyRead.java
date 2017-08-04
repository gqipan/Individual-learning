package com.pan.sync;
/**
 * 脏读问题
 * 业务整体需要使用完整的synchronized，保持业务的原子性。
 *
 * 实际上在 getValue 的时候，setValue 方法没有完成，所以读取到的变量还是旧的变量。
 * 造成脏读的问题, 所以最好获取变量的方法上也加上同步锁 synchronized
 */
public class DirtyRead {

	private String username = "test";
	private String password = "123";
	
	public synchronized void setValue(String username, String password){
		this.username = username;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.password = password;
		
		System.out.println("setValue最终结果：username = " + username + " , password = " + password);
	}

	/**synchronized**/
	public void getValue(){
		System.out.println("getValue方法得到：username = " + this.username + " , password = " + this.password);
	}

	public static void main(String[] args) throws Exception{
		
		final DirtyRead dr = new DirtyRead();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setValue("z3", "456");		
			}
		});
		t1.start();
		Thread.sleep(1000);
		
		dr.getValue();
	}
	
	
	
}
