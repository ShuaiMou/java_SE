package cn.saul.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author moushuai
 * 
 * Set接口：
 * 
 *一个不包含重复元素的 collection。更确切地讲，set 不包含满足 e1.equals(e2) 的元素对 e1 和 e2，并且最多包含一个 null 元素.

	1.无序的（不保证顺序）
	2.不允许重复元素
	3.具体实现有 HashSet, TreeSet, LinkedHashSet
	4.如何选择 set 的具体实现？
	–1）如果需要排序，选择 TreeSet
	–2）如果不要排序，也不用保证顺序选择 HashSet
	–3）如果不要排序，要保证顺序，选择 LinkedHashSet
 */
public class SetDemo {
	
	/**
	 * hashSet
	 * 1.实现原理，基于哈希表（HashMap）实现
	 * 2.不允许重复，可以有一个NULL元素
	 * 3.不保证顺序恒久不变
	 * 4.添加元素时，把元素作为HashMap的key存储， HashMap的value使用一个固定的object对象。
	 * 5.排除重复元素是通过 equals 来检查对象是否相同。
	 * 6.判断两个对象是否相同，先判断两个对象的hashcode是否相同（如果两个对象hashcode相同，不一定是同一个对象；如果hashcode不同，肯定不是同一个对象）。
		如果不同，则两个对象不是同一个对象；如果相同，还要进行equals判断，equals相同则是同一个对象，不同则不是同一个对象。
	 * 7.自定义对象要认为属性值都相同时为同一个对象，有这种需求时，那么我们要重写对象所在类的 hashCode 和 equals 方法

	 */
	public static void hashSet() {
		Set<String> set = new HashSet<String>();
		set.add("XiaoLin");
		set.add("DaZhuang");
		set.add("XiaoMing");
		
		//转换为Array来遍历
		String[] names = set.toArray(new String[] {});
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("-----------------------------");
		Set<Cat> set2 = new HashSet<Cat>();
		Cat c1 = new Cat("aaa", 1, 12);
		Cat c2 = new Cat("bbb", 2, 13);
		Cat c3 = new Cat("ccc", 3, 14);
		Cat c4 = new Cat("aaa", 1, 12);
		set2.add(c1);
		set2.add(c2);
		set2.add(c3);
		set2.add(c4);
		System.out.println("set2 size = " + set2.size());
		for(Cat cat : set2) {
			System.out.println(cat);
		}
	}
	
	/**
	 * TreeSet
	 * 有序的，基于TreeMap（二叉树数据结构），对象需要比较大小，通过对象比较器来实现。
	 * 对象比较器还可以用来去除重复元素，如果自定义的数据类，没有实现比较器接口，将无法添加到TreeSet集合中。
	 */
	public static void treeSet() {
		Set<Cat> treeSet = new TreeSet<>(new MyComparator());
		Cat c1 = new Cat("aaa", 1, 12);
		Cat c2 = new Cat("bbb", 2, 13);
		Cat c3 = new Cat("ccc", 3, 14);
		Cat c4 = new Cat("aaa", 4, 12);
		treeSet.add(c1);
		treeSet.add(c2);
		treeSet.add(c4);
		treeSet.add(c3);
		
		for(Cat cat : treeSet) {
			System.out.println(cat);
		}
	}	
	
	/**
	 * LinkedHashset
	 */
	public static void linkedHashset() {
		Set<Cat> linkedhashSet = new LinkedHashSet<Cat>();
		Cat c1 = new Cat("aaa", 1, 12);
		Cat c2 = new Cat("bbb", 3, 13);
		Cat c3 = new Cat("ccc", 5, 14);
		Cat c4 = new Cat("aaa", 4, 12);
		linkedhashSet.add(c1);
		linkedhashSet.add(c2);
		linkedhashSet.add(c3);
		linkedhashSet.add(c4);
		
		for(Cat cat : linkedhashSet) {
			System.out.println(cat);
		}
	}
	public static void main(String[] args) {
		//hashSet();
		//treeSet();
		linkedHashset();
	}

}
