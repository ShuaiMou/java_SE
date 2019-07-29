package cn.saul.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义注解
 * @author moushuai
 *
 */
//注解的使用范围
@Target(value = {ElementType.TYPE, ElementType.METHOD,  ElementType.CONSTRUCTOR})
//作用范围 
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	public String name();
	public int id();
	public int age() default 2; //给变量设置默认值
	public String[] likes(); //定义一个数组变量
	public Color color(); //定义一个枚举变量
}
