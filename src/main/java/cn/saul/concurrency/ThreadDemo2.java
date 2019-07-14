package cn.saul.concurrency;

/**
 * join ：
 * 加入线程，让调用线程先执行指定时间或执行完毕
 * @author moushuai
 *
 */
public class ThreadDemo2 {
	public static void main(String[] args) {
		MyRunnable2 mr = new MyRunnable2();
		Thread t = new Thread(mr);
		t.start();
		
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "--" + i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (20 == i) {
				try {
					t.join();//让t线程执行完毕
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class MyRunnable2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + " --" + i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}