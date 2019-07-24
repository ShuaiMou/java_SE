package cn.saul.collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("good", "good", "study", "day", "day","up");
		
		//1.foreach
		//stream.forEach((String str)->{System.out.println(str);});
		
		//2.filter
		//stream.filter((String str)-> str.length() > 3).forEach(System.out::println);
		
		//3.distincct
		//stream.distinct().forEach(System.out::println);
		
		//4.map
		//stream.map(s->s.toUpperCase()).forEach(System.out::println);
		
		//5.flatMap
		//Stream<List<Integer>> ss = Stream.of(Arrays.asList(1,2,3),Arrays.asList(4,5));
		//ss.flatMap(list -> list.stream()).forEach(System.out::println);
		
		//6.reduce
		//Optional< String> optional = stream.reduce((s1,s2)->s1.length() > s2.length() ? s1:s2);
		//System.out.println(optional.get());
		
		//7.Collect
		
		List<String> list = stream.collect(Collectors.toList());
		list.forEach(System.out::println);
	}
}
