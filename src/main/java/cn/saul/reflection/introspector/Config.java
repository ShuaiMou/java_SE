package cn.saul.reflection.introspector;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Config {
	
	private int id;
	private String username;
	private String password;
	private String url;
	
	
	
	public Config(int iD, String username, String password, String url) {
		super();
		id = iD;
		this.username = username;
		this.password = password;
		this.url = url;
	}



	public Config() {
		super();
	}
	
	
}
