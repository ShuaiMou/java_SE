package cn.saul.reflection.aop;

public class LogAdvice implements Advice {

	@Override
	public void beforeAdvice() {
		System.out.println("start time ：" + System.currentTimeMillis());

	}

	@Override
	public void afterAdvice() {
		System.out.println("end time : " + System.currentTimeMillis());

	}

}
