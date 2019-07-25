package cn.saul.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * @author moushuai
 *
 *将键映射到值的对象，一个映射不能包含重复的键；每个键最多只能映射到一个值。
 *
 *- 1.键值对存储一组对象
 *- 2.key不能重复（唯一），value可以重复。
 *- 3.具体的实现类：HashMap，TreeMap，Hashtable， LinkedHashMap
 */
public class MapDemo {
	/**
	 * 1.hashMap
	 * 实现原理：
	 * 1）基于哈希表（数组，链表，红黑树）JDK 1.8
	 * 2）默认加载因子为0.75， 默认数组大小是16.
	 * 3）把对象存储到哈希表中，如何存储：
	 * 	把 key 对象通过 hash() 方法计算 hash 值，然后用这个 hash 值对数组长度取余（默认16），来决定对该 key
	 *  对象在数组中对存储位置， 当这个位置有多个对象时，以链表结构存储， JDK1.8后， 当链表长度大于8时，链表将
	 *  转换为红黑树结构存储。
	 *  
	 *  这样的目的，是为了取值更快。存储的数据量越大，性能表现越明显。
	 *  
	 * 4）扩充原理： 当数组的容量超过来75%，那么该数组需要扩容：当前数组容量 << 1，扩大1倍。扩充次数过多
	 *  会影响性能。每次扩充哈希表重新散列（重新计算每个对象的存储位置）。在实际开发中尽量要减少扩充次数
	 *  带来的性能问题。
	 *  
	 *  5）线程不安全，适合在单线程中使用。
	 */
	public static void hashMap () {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "xiaolin");
		map.put(2,"saul");
		map.put(3,"alex");
		map.put(4, "joey");
		
		//遍历key 和 value
		System.out.println("----------遍历key 和 value----------------");
		Set<Entry<Integer, String>> set = map.entrySet();
		set.forEach((entry)-> System.out.println(entry.getKey() + "->" +entry.getValue()));
		
		System.out.println("----------遍历key----------------");
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println( i + "->" + map.get(i));
		}
		
		System.out.println("----------遍历value----------------");
		Collection<String> list = map.values();
		for (String str : list) {
			System.out.println(str);
		}
		
		System.out.println("----------forEach----------------");
		map.forEach((key, value) -> System.out.println(key + "->" + value));
	}
	
	/**
	 * 2.Hashtable
	 * JDK 1.0
	 * 基于哈希表实现（数组，链表）
	 * 默认数组大小为11， 负载因子0.75
	 * 扩充方式： 原数组大小 << 1 + 1
	 * 线程安全，用在多线程访问时。
	 */
	public static void hashtable() {
		Map<String, String> table = new Hashtable<String, String>();
		table.put("one", "xialin");
		table.put("two", "saul");
		table.put("three", "xiaoqiang");
		table.forEach((key, value)->System.out.println(key + "->" + value));
	} 
	
	/**
	 * 3.LinkedHashMap
	 * 是hashMap的子类，由于hashMap不能保证顺序恒久不变，此类使用一个双重链表来维护元素的添加顺序。
	 */
	public static void linkedHashMap() {
		Map<String, String> table = new LinkedHashMap<String, String>();
		table.put("one", "xialin");
		table.put("two", "saul");
		table.put("three", "xiaoqiang");
		table.forEach((key, value)->System.out.println(key + "->" + value));
	}
	
	/**
	 * 基于二叉树的红黑树实现
	 */
	public static void treeMap() {
		Map<Cat, String> treeMap = new TreeMap<Cat, String>(new MyComparator());
		treeMap.put(new Cat("huhu", 1, 12), "cat1");
		treeMap.put(new Cat("niuniu", 2, 13), "cat2");
		treeMap.put(new Cat("jojo", 3, 14), "cat3");
		treeMap.put(new Cat("lolo", 1, 15), "cat4");
		treeMap.forEach((key, value)->System.out.println(key + "->" + value));
	}
	
	public static void main(String[] args) {
//		hashMap();
//		hashtable();
//		linkedHashMap();
		treeMap();
	}
}
