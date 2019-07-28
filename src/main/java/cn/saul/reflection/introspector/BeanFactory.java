package cn.saul.reflection.introspector;

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
 * 通过内省的API来装配一个Bean对象， Bean对象的值是通过配置文件中来获取
 * 目的是为了提高可维护性
 * @author moushuai
 *
 */
public class BeanFactory {
	private static Properties propt = new Properties();
	static {
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/saul/reflection/introspector/config.properties");
		try {
			propt.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object getBean(String name) {
		Object bean = null;
		try {
			Class<?> beanClass = Class.forName(propt.getProperty(name));
			bean = beanClass.newInstance();
			
			//通过类信息获取javaBean的描述信息
			BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
			
			//通过javaBean描述信息，获取该类的所有属性描述器
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor descriptor : propertyDescriptors) {
				String propertyName = descriptor.getName();
				Method writeMethod = descriptor.getWriteMethod();
				if ("id".equals(propertyName)) {
					//调用属性的 set 方法
					writeMethod.invoke(bean, Integer.parseInt(propt.getProperty("bean.id")));
				}else if ("username".equals(propertyName)) {
					//调用属性的 set 方法
					writeMethod.invoke(bean, propt.getProperty("bean.username"));
				}else if ("password".equals(propertyName)) {
					//调用属性的 set 方法
					writeMethod.invoke(bean, propt.getProperty("bean.password"));
				}else if ("url".equals(propertyName)) {
					//调用属性的 set 方法
					writeMethod.invoke(bean, propt.getProperty("bean.url"));
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
