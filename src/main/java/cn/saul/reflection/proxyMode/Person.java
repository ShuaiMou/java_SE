package cn.saul.reflection.proxyMode;

public class Person implements Action, Hotel{

	@Override
	public void shopping() {
		System.out.println("付款海淘到到一件物美价廉的商品");
	}

	@Override
	public void reservation() {
		System.out.println("预定酒店");
		
	}

}
