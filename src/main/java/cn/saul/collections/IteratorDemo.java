package cn.saul.collections;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

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
	
	//JDK1.8新的迭代方法
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
	}
}
