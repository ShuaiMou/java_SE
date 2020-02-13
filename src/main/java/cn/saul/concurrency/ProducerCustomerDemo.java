package cn.saul.concurrency;

/**
 * 两个线程间协同工作，先生产，再消费
 * sleep 与 wait的区别：
 * sleep：让线程进入休眠状态，让出CPU时间片，不释放对象监视器的所有权（对象所）
 * wait： 让线程进入等待状态，让出CPU时间片，并释放对监视器对所有权，等待其他线程通过notify方法唤醒。
 * @author moushuai
 *
 */
public class ProducerCustomerDemo {
	public static void main(String[] args) {
		Food food = new Food();
		producer producer = new producer(food);
		customer customer = new customer(food);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(customer);
		t1.start();
		t2.start();
	}

}

class Food{
	private String name;
	private String desc;
	private boolean flag = true;//True表示可以生产，false表示可以消费
	
	public Food(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	public Food() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", desc=" + desc + "]";
	}
	
	/**
	 * 生产方法
	 * @param name
	 * @param desc
	 */
	public synchronized void set(String name, String desc) {
		//不能生产
		if (!flag) {
			try {
				this.wait();//线程进入等待状态，释放监视器的所有权（对象锁）
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.desc = desc;
		flag = false;
		this.notify();//唤醒等待的线程（随机其中一个）
	}
	
	/**
	 * 消费方法
	 */
	public synchronized void get() {
		//不能消费
		if (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + " -> " + desc);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag = true;
		this.notify();
	}
}

/**
 * 生产者
 * @author moushuai
 *
 */
class producer implements Runnable{
	private Food food;
	public producer(Food food) {
		this.food = food;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			if ( i%2 == 0) {
				food.set("beef", "very delicious!");
			}else {
				food.set("java sets", "nice sets, good for programmer!");
			}
		}
	}
}

/**
 * 消费者
 * @author moushuai
 *
 */
class customer implements Runnable{
	private Food food;
	public customer(Food food) {
		 this.food = food;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			food.get();
		}
	}
	
}