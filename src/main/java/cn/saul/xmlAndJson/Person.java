package cn.saul.xmlAndJson;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Person {
	private String personId;
	private String name;
	private String address;
	private String tel;
	private String email;
	
	public Person(String personId, String name, String address, String tel, String email) {
		super();
		this.personId = personId;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
	}

	public Person() {
		super();
	}
	
}
