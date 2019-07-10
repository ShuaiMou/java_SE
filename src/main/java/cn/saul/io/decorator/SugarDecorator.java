package cn.saul.io.decorator;

/**
 * 具体的装饰者类
 * @author moushuai
 *
 */
public class SugarDecorator extends Decoractor {

	public SugarDecorator(Drink drink) {
		super(drink);
	}
	@Override
	public float cost() {
		return super.cost() + 1.0f;
	}
	
	@Override
	public String description() {
		return super.description() + "+糖";
	}
	
}
