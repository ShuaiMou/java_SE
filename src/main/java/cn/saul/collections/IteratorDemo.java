package cn.saul.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 
 * @author moushuai
 *遍历集合的方式有以下几种：
	1、 Iterator
	2、 ListIterator
	3、 Enumeration
	4、 foreach
	其中Iterator的使用率最高，在JDK1.5后新增的foreach也被大量使用。
 *
 */
public class IteratorDemo {
	
	//Iterator
	public static void iterator(Collection<Cat> c) {
		Iterator<Cat> iterator = c.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	//forEach
	public static void forEach(Collection<Cat> c) {
		for(Cat cat : c) {
			System.out.println(cat);
		}
	}
	
	//Enumeration
	public static void enumeration() {
		Vector<String> list = new Vector<String>();
		list.add("xiaolin");
		list.add("dazhuang");
		list.add("huanqiang");
		Enumeration<String> enumeration = list.elements();
		while(enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
	}
	
	//JDK1.8新的迭代方法，
	//Consumer<T>接口	消费者接口
	public static void forEach() {
		List<Cat> list = new LinkedList<Cat>();
		Cat c1 = new Cat("aaa", 1, 12);
		Cat c2 = new Cat("bbb", 2, 13);
		Cat c3 = new Cat("ccc", 3, 14);
		list.add(c3);
		list.add(c2);
		list.add(c1);
		//list.forEach((Cat cat) -> {System.out.println(cat);});
		//list.forEach((cat) -> {System.out.println(cat);});
		list.forEach( cat -> {System.out.println(cat);});
		}
	
	//Function<T,R> 接口	表示接受一个参数并产生结果的函数。
	public static void functionTest() {
		String str = toUppercaseString("xiaoxiao", new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		});
		System.out.println(str);
	}
	
	public static String toUppercaseString(String str, Function<String, String> f) {
		return f.apply(str);
	}
	
	
	//- Supplier<T>接口	代表结果供应商。
	public static void supplierTest() {
		List<Integer> list = getNums(10, ()->(int)(Math.random()*100));
		list.forEach(System.out::println);
	}
	
	public static List<Integer> getNums(int num, Supplier<Integer> supplier){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < num; i++) {
			list.add(supplier.get());
		}
		return list;
	}
	
	//Predicate<T>接口	断言接口
	public static void predicateTest() {
		String[] strs = {"hello", "hi","jach", "mike"};
		List<String> input = Arrays.asList(strs);
		List<String> result = test(input, (String s)->s.contains("h"));
		result.forEach(System.out::println);
		
	}
	
	public static List<String> test(List<String> list, Predicate<String> p){
		List<String> results = new ArrayList<String>();
		for (String string : list) {
			if(p.test(string))
				results.add(string);
		}
		return results;
	}
	
	public static void main(String[] args) {
		List<Cat> list = new LinkedList<Cat>();
		Cat c1 = new Cat("aaa", 1, 12);
		Cat c2 = new Cat("bbb", 2, 13);
		Cat c3 = new Cat("ccc", 3, 14);
		list.add(c3);
		list.add(c2);
		list.add(c1);
		
		System.out.println("-------------iterator-------------");
		iterator(list);
		System.out.println("--------------------forEach-------------");
		forEach(list);
		System.out.println("--------------------Enumeration-------------");
		enumeration();
		System.out.println("--------------------JDK1.8新的迭代方法-------------");
		forEach();
		System.out.println("------------------Function<T,R> 接口	表示接受一个参数并产生结果的函数。---------------");
		functionTest();
		System.out.println("---------------- Supplier<T>接口	代表结果供应商。-----------------");
		supplierTest();
		System.out.println("--------------------Predicate<T>接口	断言接口-------------");
		predicateTest();
	}
}
