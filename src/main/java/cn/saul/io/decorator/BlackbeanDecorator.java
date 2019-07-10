package cn.saul.io.decorator;

public class BlackbeanDecorator extends Decoractor{
	
	public BlackbeanDecorator(Drink drink) {
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost() + 2.0f;
	}
	
	@Override
	public String description() {
		return super.description() + "+黑豆";
	}
}
