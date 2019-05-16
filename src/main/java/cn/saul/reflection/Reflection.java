package cn.saul.reflection;

import org.junit.Test;

public class Reflection {
	/**
	 * 用得到的Class对象创建对应实例
	 */
	@Test
	public void test2(){
		Class<Car> class3 = null;
		try {
			class3 = (Class<Car>) Class.forName("cn.saul.reflection.Car");
			System.out.println(class3.getName());
			Car car = class3.newInstance();
			car.setName("奥迪");
			System.out.println(car.getName());
			
		} catch (ClassNotFoundException e) {
			System.out.println("class 对象不存在");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 利用反射获取class对象的三种方式:
	 * 	1.instance.getClass
	 * 	2.Class.class
	 * 	3.Class.forName("类名")
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test1(){
		Car car = new Car();
		Class<Car> class1 = (Class<Car>) car.getClass();
		@SuppressWarnings("rawtypes")
		Class class2 = Car.class;
		Class<Car> class3 = null;
		try {
			class3 = (Class<Car>) Class.forName("cn.saul.reflection.Car");
		} catch (ClassNotFoundException e) {
			System.out.println("class 对象不存在");
		}
		System.out.println(class1 + "\n" + class2 + "\n" + class3);
	}
}
