package cn.saul.reflection;

import lombok.Getter;
import lombok.Setter;

/**
 * used for testing reflection
 * 
 * @author Saul
 * 2019-05-13
 *
 */

@Setter
@Getter
public class Car {
	private String name;
	private String type;
	private int volum;
	public String color;
	
	public Car(){
		
	}
	
	public Car(String name, String type, int volum, String color){
		this.name = name;
		this.type = type;
		this.volum = volum;
		this.color = color;
	}
	
}
