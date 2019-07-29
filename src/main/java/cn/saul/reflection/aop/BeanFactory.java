package cn.saul.reflection.aop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * AOP框架的简单实现
 * @author moushuai
 *
 */
public class BeanFactory {
	private Properties propt;
	
	public BeanFactory(InputStream stream) {
		propt = new Properties();
		try {
			propt.load(stream);
		} catch (IOException e) {
			System.out.println("Failed in initializing properties stream!");
		}
	}
	
	/**
	 * 获取一个bean实例
	 * @param name
	 * @return
	 */
	public Object getBean(String name) {
		String className = propt.getProperty(name);
		Object bean = null;
		try {
			//获取ProxyFactoryBean的class对象
			Class<?> aClass = Class.forName(className);
			//实例化对象
			bean = aClass.newInstance();
			Object target = Class.forName(propt.getProperty(name + ".target")).newInstance();
			Object advice = Class.forName(propt.getProperty(name + ".advice")).newInstance();
			
			//通过内省实现对ProxyFactoryBean的属性赋值
			BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor pd : propertyDescriptors) {
				String propertyName = pd.getName();
				Method writeMethod = pd.getWriteMethod();
				if ("target".equals(propertyName)) {
					writeMethod.invoke(bean, target);
				}
				if ("advice".equals(propertyName)) {
					writeMethod.invoke(bean, advice);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
