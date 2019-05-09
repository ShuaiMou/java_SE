package cn.saul.exception;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 测试lombok
 * 
 * @author Saul
 * 2019-05-06
 *
 */
@Setter
@Getter
public class Car {
	
	private String name;
	private String model;
	private Date produceDate;
	private int age;
	
	public boolean caculateAge(int age) throws InvalidMoveException{
		if (this.age > age) {
			throw new InvalidMoveException(Integer.toString(this.age));
		}
		return true;
	}
	
	public static void main(String[] args) {
		Car car = new Car();
		car.setAge(19);
		int flag = 1;
		try {
			if (car.caculateAge(18)) {
				flag = -1;
			}
		} catch (InvalidMoveException e) {
			System.out.printf("invalid remove %s",e.getMessage());
			flag = 1;
		}
	}
	
}
