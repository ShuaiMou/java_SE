package cn.saul.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
	private List<String> list;
	@Before
	public void before() {
		list = new ArrayList<String>();
		list.add("xiaolin");
		list.add("dazhuang");
		list.add("huanqiang");
	}
	
	/**
	 * 排序操作（主要针对List接口相关）
	 */
	@Test
	public void test1() {
		
		
		//reverse(List list)：反转指定List集合中元素的顺序
//		Collections.reverse(list);
		
		//shuffle(List list)：对List中的元素进行随机排序（洗牌）
//		Collections.shuffle(list);
		
		//sort(List list)：对List里的元素根据自然升序排序
		//sort(List list, Comparator c)：自定义比较器进行排序
//		Collections.sort(list);
		
		//swap(List list, int i, int j)：将指定List集合中i处元素和j出元素进行交换
//		Collections.swap(list, 0, 2);
		
		//rotate(List list, int distance)：将所有元素向右移位指定长度，如果distance等于size那么结果不变
		Collections.rotate(list, 1);
		System.out.println(list);
	}
	
	/**
	 * 查找和替换（主要针对Collection接口相关）
	 */
	@Test
	public void test2() {
		//binarySearch(List list, Object key)：使用二分搜索法，以获得指定对象在List中的索引，前提是集合已经排序
//		Collections.sort(list);
//		System.out.println(Collections.binarySearch(list, "xiaolin"));
		
		
		//max(Collection coll)：返回最大元素
		//max(Collection coll, Comparator comp)：根据自定义比较器，返回最大元素
		//min(Collection coll)：返回最小元素
		//min(Collection coll, Comparator comp)：根据自定义比较器，返回最小元素
//		System.out.println(Collections.max(list));
		
		//fill(List list, Object obj)：使用指定对象填充
//		Collections.fill(list, "null"); 
//		System.out.println(list); //[null, null, null]
		
		//frequency(Collection Coll, Object o)：返回指定集合中指定对象出现的次数
		System.out.println(Collections.frequency(list, "xiaolin"));
		
		//replaceAll(List list, Object old, Object new)：替换
		Collections.replaceAll(list, "xiaolin", "jack");
		System.out.println(list);
		
	}
}
