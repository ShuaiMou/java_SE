1.throw与throws关键字：
	throws：主要在方法的声明上使用，表示方法中不处理异常，而交给调用处处理。
			实际上对于Java程序来讲，如果没有加入任何的异常处理，默认由JVM
			进行异常的处理操作。
	throw：表示在程序中手动抛出一个异常，因为从异常处理机制来看，所有的异常
		   一旦产生之后，实际上抛出的就是一个异常类的实例化对象，那么此对象也可以由
	       throw直接抛出

2.异常处理的语法规则：
	 第一.try语句不能单独存在，可以和catch、finally组成 try...catch...finally、
		 try...catch、try...finally三种结构，catch语句可以有一个或多个，finally
		 语句最多一个，try、catch、finally这三个关键字均不能单独使用。
	 第二. try, catch,finally三个代码块中变量的作用域分别独立而不能相互访问。
	 第三. 多个catch块的时候，java虚拟机会匹配其中一个异常类或其子类，就执行这个catch
	 	  块，而不会执行别的catch块。
	
3.自定义异常通常都是通过继承一个异常类来实现。
	1）.Throwable：异常的父类
	2）.Exception： 受检异常
			定义方法时必须声明所有可能会抛出的exception； 在调用这个方法时，必须捕获它
			的checked exception，不然就得把它的exception传递下去；exception是从
			java.lang.Exception类衍生出来的。例如：IOException，SQLException就属于
			Exception
			
	3）.RuntimeException： 非受检异常
		在定义方法时不需要声明会抛出runtime exception； 在调用这个方法时不需要捕获这个
		runtime exception； runtime exception是从java.lang.RuntimeException或
		java.lang.Error类衍生出来的。 例如：NullPointException，
		IndexOutOfBoundsException就属于runtime exception
		
自定义异常的实现是，提供构造方法
异常本身是没有实际功能，只是一个有意义的标识。
在函数中判断抛出异常的条件，满足即向上抛出此异常。

