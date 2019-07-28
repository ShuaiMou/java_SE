package cn.saul.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class Reflection {
	 
	@Test
	public void test5() {
		Class<Car> carClass = Car.class;
		Car car = null;
		try {
			car = carClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		car.setName("benz");
		car.setColor("red");
		car.setType("xl");
		car.setVolum(3);
		//获取类的包名
		Package package1 = carClass.getPackage();
		System.out.println(package1.getName());
		
		//获取公共的方法，包括继承的公有方法
		Method[] methods = carClass.getMethods();
		for(Method method : methods) {
			System.out.println(method);
			if (method.getName().equals("toString")) {
				try {
					String str = (String) method.invoke(car);
					System.out.println(str);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("------------------------------------------");
		Method[] declaredMethods = carClass.getDeclaredMethods();
		for (int i = 0; i < declaredMethods.length; i++) {
			System.out.println(declaredMethods[i]);
			if (declaredMethods[i].getName().equals("changeColor")) {
				//设置私有方法可以被访问（去除访问修饰符的检查）
				declaredMethods[i].setAccessible(true);
				try {
					declaredMethods[i].invoke(car);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	} 
	
	/**
	 * 获取类属性
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test4() {
		Class<Car> carClass = null;
		try {
			carClass = (Class<Car>) Class.forName("cn.saul.reflection.Car");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//获取非私有属性
		Field[] fields = carClass.getFields();
		System.out.println(fields.length);
		
		//获取所有属性（包含私有属性）
		Field[] declaredFields = carClass.getDeclaredFields();
		System.out.println(declaredFields.length);
		
		for (int i = 0; i < declaredFields.length; i++) {
			int modifiers = declaredFields[i].getModifiers();
			System.out.println(Modifier.toString(modifiers) + " " + declaredFields[i].getType() + " " + declaredFields[i].getName());
		}
		
	}
	
	//获取所有构造方法
	@Test
	public void test3() {
		Class<Car> carClass = Car.class;
		Constructor<?>[] constructors = carClass.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(constructors[i].getName());
			System.out.println(constructors[i].getParameterCount());
		}
		try {
			//获取一个指定的构造方法
			Constructor<Car> constructor = carClass.getConstructor(String.class, String.class, int.class, String.class);
			try {
				//调用带参数的构造器来实例化对象
				Car car = constructor.newInstance("audi","xl",2,"red");
				System.out.println(car);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过反射实例化对象
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test2(){
		Class<Car> class3 = null;
		try {
			class3 = (Class<Car>) Class.forName("cn.saul.reflection.Car");
			System.out.println(class3.getName());
			//通过Class对象实例化类对象，调用了默认无参的构造方法。
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
