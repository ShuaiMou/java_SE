package cn.saul.reflection.introspector;

import org.junit.Test;

public class TestIntrospector {
	
	@Test
	public void testGetBean() {
		Config config = (Config) BeanFactory.getBean("bean.name");
		System.out.println(config);
	}
}
