package cn.saul.reflection.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProxyFactoryBean implements InvocationHandler{
	private Object target;
	private Advice advice;
	
	public Object getProxy() {
		Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		return proxyInstance;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		advice.beforeAdvice();
		Object result = method.invoke(target, args);
		advice.afterAdvice();
		return result;
	}
	
	
}
