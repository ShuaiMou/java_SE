package cn.saul.concurrency;

/**
 * 线程的休眠
 * 在当前线程的执行中，暂停指定的毫秒数，释放CPU的时间片。
 * @author moushuai
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Mythread mt = new Mythread();
		
		MyRunnable mr = new MyRunnable();
		Thread t = new Thread(mr);
		mt.start();
		t.start();
	}
	
}
/**
 * 实现线程的第一种方式：实现 Runnable接口（推荐使用）
 * @author moushuai
 *
 */
class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "+" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

/**
 * 实现线程的第二种方式： 继承 Thread 类
 * @author moushuai
 *
 */
class Mythread extends Thread{
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "+" + i );
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
