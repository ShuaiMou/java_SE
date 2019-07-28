package cn.saul.reflection;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

public class BeanUtilTest {
	
	@Test
	public void test1() {
		//从客户端获取的数据
		String name = "audi";
		String type = "Xl";
		String volum = "3";
		String color = "black";
		Car car = new Car();
		
		try {
			/**
			 * BeanUtils自动完成类型转换
			 */
			BeanUtils.setProperty(car, "name", name);
			BeanUtils.setProperty(car, "type", type);
			BeanUtils.setProperty(car, "volum", volum);
			BeanUtils.setProperty(car, "color", color);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(car);
		
	}
}
