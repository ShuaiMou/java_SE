package cn.saul.io.decorator;

public class EggDecorator extends Decoractor{
	public EggDecorator(Drink drink) {
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost() + 3.0f;
	}
	
	@Override
	public String description() {
		return super.description() + "+鸡蛋";
	}
}
