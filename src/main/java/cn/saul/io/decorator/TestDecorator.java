package cn.saul.io.decorator;

public class TestDecorator {
	public static void main(String[] args) {
		Drink drink = new SoyabeanMilk();
		SugarDecorator sugar = new SugarDecorator(drink);
		EggDecorator eggs = new EggDecorator(sugar);
		BlackbeanDecorator blackbean = new BlackbeanDecorator(eggs);
		
		System.out.println("你点的豆浆是：" + blackbean.description());
		System.out.println("一共花了： " + blackbean.cost() + "元");
	}
}
