package cn.saul.lombok;

import org.junit.Test;

public class TestCase {
	@Test
	public void  testGetterAndSetter(){
		Car car1 = new Car();
		Car car2 = new Car();
		car1.setName("name");
		car2.setName("name");
		System.out.println(car1.equals(car2));
		System.out.println(car1.hashCode());
		System.out.println(car1);
	}
}
