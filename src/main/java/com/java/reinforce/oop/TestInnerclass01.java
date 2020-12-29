package com.java.reinforce.oop;

import com.java.reinforce.oop.Outer01.Inner01;
//注意:
//一个.java类中只允许存在一个被public修饰的类,并且被修饰的类要与类名相同
//静态方法内部只能访问同一个类中的静态方法
//对于实力内部类对象的创建,应先有外部类对象,再有内部类对象
//对于实力内部类对象会有外部类对象的一个引用
class Outer01{
	int a;
	static int b;
	/**
	 * 实力内部类
	 * 1.位置:类的内部,方法的外部
	 * 2.没有static修饰,访问控制符任意
	 * 3.应用:依托于外部类对象,可以访问外部类所有成员
	 */
	class Inner01{
		public void display() {
			System.out.println(this);
			System.out.println(Outer01.this);
			System.out.println(a);
			System.out.println(b);
		}
	}
	public void create() {
		this.new Inner01().display();
		//以上this可以省略
		     new Inner01().display();
	}
}

public class TestInnerclass01 {
	public static void main(String[] args) {
		Outer01 out=new Outer01() ;
		Inner01 in=out.new Inner01();
		in.display();
		//
		Inner01 inner=out.new Inner01();
		inner.display();
	
		



	}





}
