package cn.saul.annotation;

import java.lang.annotation.Annotation;
import org.junit.Test;

public class MyAnnotationTest {
	
	private Cat cat;
	//反射处理注解
	@Test
	public void test() {
		Class<?> class1 = Cat.class;
		
		//获取类上应用的所有注解
		Annotation[] annotations = class1.getAnnotations();
		MyAnnotation myAnnotation = null;
		for (int i = 0; i < annotations.length; i++) {
			if (annotations[i].annotationType().getName().equals("cn.saul.annotation.MyAnnotation")) {
				myAnnotation = (MyAnnotation) annotations[i];
				
			}
		}
		//获取注解上的变量
		String name = myAnnotation.name();
		int age = myAnnotation.age();
		Color color = myAnnotation.color();
		String[] likes = myAnnotation.likes();
		int id = myAnnotation.id();
		try {
			cat = (Cat) class1.newInstance();
			cat.setAge(age);
			cat.setColor(color);
			cat.setId(id);
			cat.setLikes(likes);
			cat.setName(name);
			System.out.println(cat);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
