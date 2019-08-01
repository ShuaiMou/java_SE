package cn.saul.reflection.singleton;

import java.io.Serializable;

/**
 * 单例模式：
 * 1.多线程访问的安全问题，加synchronized同步代码块。
 * 2.加上volatile关键字保证变量的一致性
 * 3.防止反射调用私有构造方法
 * 4。让单例类序例化安全（让单例类实现Serializable接口）
 * @author moushuai
 *
 */

public class Singleton implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static volatile Singleton singleton = null;
	private Singleton(){
		//防止反射调用私有构造方法
		if (singleton != null) {
			throw new RuntimeException("this class is singleton, and the object has been created");
		}
	}
	
	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
