package cn.saul.concurrency;

import org.junit.Test;

public class TestConcurrency {
	@Test
	public void test1() {
		Mythread mt = new Mythread();
		
		MyRunnable mr = new MyRunnable();
		Thread t = new Thread(mr);
		mt.start();
		t.start();
		
	}
}
