package cn.saul.reflection.proxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CreateProxy implements InvocationHandler {
	
	private Object target; //被代理到对象
	
	//用于创建代理对象到方法。
	public Object create(Object target) {
		this.target = target;
		Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		return proxyInstance;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("上海外寻找客户需要到产品...");
		System.out.println("跟客户确认物品");
		method.invoke(target, args);
		System.out.println("完成本次海淘");
		return null;
	}

}
