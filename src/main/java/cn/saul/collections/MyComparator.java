package cn.saul.collections;

import java.util.Comparator;

public class MyComparator implements Comparator<Cat> {

	@Override
	public int compare(Cat o1, Cat o2) {
		return o1.getId() - o2.getId();
	}

}
