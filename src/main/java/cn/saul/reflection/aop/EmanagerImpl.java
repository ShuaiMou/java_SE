package cn.saul.reflection.aop;

import lombok.ToString;

@ToString
public class EmanagerImpl implements Emanager {
	private String name;

	@Override
	public void add(String name) {
		this.name = name;
		System.out.println("add name successfully!");

	}
	

}
