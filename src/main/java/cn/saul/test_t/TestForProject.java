package cn.saul.test_t;

import org.junit.Test;

public class TestForProject {
	@Test
	public void test1() {
		 String regex = ".*(people|staff|profile|faculty).*";
		String str1 = "/about-us/people/paul-ayres/";
		String str2 = "/staff/dr-riccardo-paolini";
		boolean s1 = str1.matches(regex);
		boolean s2 = str2.matches(regex);
		System.out.println(s1 +"," + s2);
		String str3 = "sjdk ddsd";
		boolean s3 = str3.matches("([a-zA-Z]*\\s){1,3}[a-zA-Z]*");
		System.out.println(s3);
	}
}
