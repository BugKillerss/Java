package com.java.reinforce.oop;
class Outer02{
	int a;
	static int b;
	/**
	 * 静态内部类
	 * 1.位置:类的内部,方法的外部
	 * 2.修饰:使用static修饰,可以任意访问修饰符
	 * 3应用:不依赖于外部类对象,可以访问外部类中的静态方法
	 */
	static class Inner02{
		int c;
		static int d;
		//实例代码块(每次创建对象时都会执行)
		{
			//a=100;
			b=100;
			c=100;
			d=10;
			System.out.println(this);
			
		}
		//静态代码块,在类加载时会被执行,并且只被执行一次
		static {
			//a=100;
			b=100;
			//c=10;
			d=20;
			//System.out.println(this);
		}
		
		public void display() {
			System.out.println(b);
			//System.out.println(a);错误:静态类中的方法中只能访问静态成员,你不能访问非静态成员
			System.out.println(this);
			//System.out.println(Outer02.this);错误
		}
	} 
	public void create() {
		new Inner02().display();
	}
}

public class TestInnerclass02 {
	public static void main(String[] args) {
		//静态内部类在外界的构建的方式
		Outer02.Inner02 in=new Outer02.Inner02(); 
		
		
	}



}
