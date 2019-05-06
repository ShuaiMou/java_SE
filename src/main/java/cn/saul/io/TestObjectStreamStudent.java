package cn.saul.io;

import java.io.Serializable;

public class TestObjectStreamStudent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String sex;
	private int age;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public TestObjectStreamStudent(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public void walk(){
		System.out.println(name + "is walking");
	}
	
	public void study(){
		System.out.println(name + "is studying");
	}

	@Override
	public String toString() {
		return "TestObjectStreamStudent [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
}
