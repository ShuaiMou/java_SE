package cn.saul.collections;

import java.util.HashMap;
import java.util.Map;

public class MapNewMethodDemo {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "xiaolin");
		map.put(2,"saul");
		map.put(3,"jojo");
		
		
//		String value = map.getOrDefault(4, "null");
//		System.out.println(value);
		
//		map.putIfAbsent(3, "alex");
//		map.forEach((k,v) -> System.out.println(k+ "->" + v));
		
//		map.compute(1, (k,v)-> v+"1");
//		map.forEach((k,v) -> System.out.println(k+ "->" + v));
		
		map.merge(1, "888", (oldv, newv)-> oldv.concat(newv));
		map.forEach((k,v) -> System.out.println(k+ "->" + v));
		
	}
}
