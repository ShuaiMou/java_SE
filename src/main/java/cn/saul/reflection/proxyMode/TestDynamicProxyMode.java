package cn.saul.reflection.proxyMode;

import org.junit.Test;

public class TestDynamicProxyMode {
	@Test
	public void test1() {
		CreateProxy createProxy = new CreateProxy();//用来创建代理对象到对象
		Action person = new Person();
		Action proxy = (Action) createProxy.create(person);
		proxy.shopping();
		
		Hotel person2 = new Person();
		Hotel proxy2 = (Hotel) createProxy.create(person2);
		proxy2.reservation();
	}
}
