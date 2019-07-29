package cn.saul.reflection.aop;

import java.io.InputStream;

import org.junit.Test;

public class AopTest {
	
	@Test
	public void test1() {
		//1.读取配置文件
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/saul/reflection/aop/config.properties");
		//2.创建bean的工厂对象
		BeanFactory beanFactory = new BeanFactory(inputStream);
		//3.获取代理对象
		ProxyFactoryBean proxyFactoryBean = (ProxyFactoryBean) beanFactory.getBean("bean");
		Emanager proxy = (Emanager) proxyFactoryBean.getProxy();
		proxy.add("hello, aop!");
		
		
	}
}
