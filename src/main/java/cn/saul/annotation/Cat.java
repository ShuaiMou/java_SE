package cn.saul.annotation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@MyAnnotation(name = "huahua", id=123, likes = {"fish","meat"},color = Color.WHITE)
public class Cat {
	private String name;
	private int id;
	private int age;
	private String[] likes;
	private Color color;
	
	public Cat(String name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	
	public Cat() {
		super();
	}

}
