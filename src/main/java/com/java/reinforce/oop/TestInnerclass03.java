package com.java.reinforce.oop;


class Outer03{
	int a;
	int b;
	public void create() {
		/*
		 * 局部内部类
		 * 1.位置:方法内部
		 * 2.修饰:不能使用static修饰,不能使用访问修饰符
		 * 3.  应用:只限于方法内部
		 */
		class Inner03{
			//此类中不允许定义静态成员
			//static int cc=200;
			int c=100;
			public void display() {
				System.out.println(this);
				System.out.println(Outer03.this);
			}
		}
		//只限于方法内部使用此对象
		new Inner03().display();
	}
}

public class TestInnerclass03 {
	public static void main(String[] args) {
		Outer03 out=new Outer03();
		out.create();
		
	}
	
	





}
