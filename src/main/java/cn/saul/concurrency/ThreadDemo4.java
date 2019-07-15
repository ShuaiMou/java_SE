package cn.saul.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.多线程共享数据时，会发生线程不安全的情况
 * 2.多线程共享数据必须使用同步
 * 3.线程同步的三种方式：
 * 	1）同步代码块
 * 	2）同步方法
 * 	3）互斥锁（reentrantLock）
 * 
 * @author moushuai
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		Myrunnable5 mr = new Myrunnable5();
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		t1.start();
		t2.start();
	}
	
}

class Myrunnable5 implements Runnable{
	private int tickets = 10; //售票
	//private Object obj = new Object(); // 同步锁
	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			/*
			 //同步块
			//synchronized(obj) {	
			synchronized(this) {	
				if (tickets > 0) {
					tickets--;
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("it remains " + tickets + " tickets");
				}	
			} */
			//method1();
			method2();
		}
	}
	
	/**
	 * 同步方法
	 */
	public synchronized void method1() {
		if (tickets > 0) {
			tickets--;
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("it remains " + tickets + " tickets");
		}	
	}
	
	//互斥锁
	private ReentrantLock lock = new ReentrantLock();
	private synchronized void method2() {
		lock.lock(); //上锁
		try {
			if (tickets > 0) {
				tickets--;
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("it remains " + tickets + " tickets");
			}	
		}finally { //放在finnaly中确保锁的释放
			lock.unlock(); //释放锁
		}
		
	}
}