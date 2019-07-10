package cn.saul.io.decorator;

/**
 * 装饰者的基类
 * @author moushuai
 *
 */
public abstract class Decoractor implements Drink{
	private Drink drink; //要装饰的对象
	
	public Decoractor(Drink drink) {
		this.drink = drink;
	}
	
	@Override
	public float cost() {
		return drink.cost();
	}

	@Override
	public String description() {
		return drink.description();
	}

}
