package cn.saul.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
/**
 *  List 接口:
 *  
 * 有序的 collection（也称为序列）。此接口的用户可以对列表中每个元素的插入位置进行精确地控制。
 * 用户可以根据元素的整数索引（在列表中的位置）访问元素，并搜索列表中的元素。

	1.有序的，可以重复
	2.允许多个null元素
	3.具体实现有 ArrayList， Vector， LinkedList
	4.在实际开发中，如何选择 List 的具体实现？
	– 1）安全性问题（线程同步，Vector）
	– 2）是否频繁插入，删除操作（LinkedList）
	– 3）是否存储后遍历
 * @author moushuai
 *
 */
public class ListDemo {
	
	/**
	 * 1.ArrayList
	 * 1.实现原理，采用动态对象数组实现，默认构造方法创建了一个空数组。
	 * 	2.第一次添加元素，扩展容量为10，之后的扩充算法：原来数组大小 + 原来大小一半
	 * 	3.不适合进行删除或插入操作
	 * 	4.为了防止数组动态扩充次数过多，建议创建ArrayList时，给定初始容量。
	 * 	5.线程不安全，适合单线程访问时使用，效率较高
	 */
	public static void arrayList() {
		List<String> list = new ArrayList<String>();
		list.add("xiaolin");
		list.add("dazhuang");
		list.add("huanqiang");
		
		//for size()遍历
		System.out.println("-------------for size()遍历-----------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.add(1, "huahua");
		
		//forEach 遍历
		System.out.println("---------------forEach 遍历----------");
		for(String str: list) {
			System.out.println(str);
		}
		
		//iterator 遍历
		System.out.println("---------------iterator 遍历----------");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}	
	}
	
	/**
	 * 2. Vector
	 * 1.实现原理，采用动态对象数组实现，默认构造方法创建了一个大小为10的对象数组。
	 *	2.扩充算法： 当增量为0时，扩充为原来大小的2倍，当增量大于0时，扩充为原数组大小 + 增量
	 *	3.不适合删除或者插入操作。
	 *	4.为了防止数组动态扩充次数过多，建议创建Vector时，给定初始容量。
	 *	5.线程安全，适合多线程访问时使用，在单线程下使用效率较低
	 */
	public static void vector() {
		List<String> list = new Vector<String>();
		list.add("xiaolin");
		list.add("dazhuang");
		list.add("huanqiang");
		
		//for size()遍历
		System.out.println("-------------for size()遍历-----------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.add(1, "huahua");
		
		//forEach 遍历
		System.out.println("---------------forEach 遍历----------");
		for(String str: list) {
			System.out.println(str);
		}
		
		//iterator 遍历
		System.out.println("---------------iterator 遍历----------");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}	
	}
	
	/**
	 * 3.LinkedList
	 * 1.实现原理，采用双向链表结构实现
	 * 2.适合插入，删除操作，性能高
	 */
	public static void linkedList() {
		List< String> list = new LinkedList<String>();
		list.add("xiaolin");
		list.add("dazhuang");
		list.add("huanqiang");
		
		//for size()遍历
		System.out.println("-------------for size()遍历-----------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.add(1, "huahua");
		
		//forEach 遍历
		System.out.println("---------------forEach 遍历----------");
		for(String str: list) {
			System.out.println(str);
		}
		
		//iterator 遍历
		System.out.println("---------------iterator 遍历----------");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}	
	}
	
	public static void main(String[] args) {
		//arrayList();
		//vector();
		linkedList();
	}

}
