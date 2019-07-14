package cn.saul.concurrency;

/**
 * 中断线程：
 * 	（1）使用interrupt方法来中断线程，设置一个中断状态（标记）
 * 	（2）使用自定义标记的方式。(推荐使用)
 * @author moushuai
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//MyRunnable3 mr = new MyRunnable3();
		//Thread t = new Thread(mr);
		MyRunnable4 mr2 = new MyRunnable4();
		Thread t2 = new Thread(mr2);
		//t.start();
		t2.start();
		
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName() + "--" + i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (20 == i) {
				//t.interrupt(); //中断线程，只是作了一个中断标记
				mr2.setFlag(false);
	 		}
		}
	}
}

class MyRunnable3 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (Thread.interrupted()) { // 测试中断状态，此方法会把中断状态清除
				break;
			}
			System.out.println(Thread.currentThread().getName() + " --" + i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
	
}

class MyRunnable4 implements Runnable{
	private boolean flag;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public MyRunnable4() {
		flag = true;
	}

	@Override
	public void run() {
		int i = 0;
		while(flag) {
			System.out.println(Thread.currentThread().getName() + " --" + i++);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}