package cn.saul.reflection.singleton;

/**
 * 单例模式
 * @author moushuai
 *
 */
public class SingletonNormal {
	private static SingletonNormal singletonNormal = null;
	private SingletonNormal(){}
	
	public static SingletonNormal getInstance() {
		if (singletonNormal == null) {
			singletonNormal = new SingletonNormal();
		}
		return singletonNormal;
	}
}
