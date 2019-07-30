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
}
