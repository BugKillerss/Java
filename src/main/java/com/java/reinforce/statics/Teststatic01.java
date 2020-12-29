package com.java.reinforce.statics;

class Static01{
	static int a =1;
	static {
		System.out.println("Static01");
	}	
}

class Static02 extends Static01{

	static {
		System.out.println("Static02");
	}

}
public class Teststatic01 {
	public static void main(String[] args) {
		//2.当子类调用调用父类的静态属性时,子类为别动加载,
		//父类为主动加载,被动加载的类,其静态代码不会执行
		System.out.println(Static02.a);
	}
}
