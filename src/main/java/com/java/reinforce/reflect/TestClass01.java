package com.java.reinforce.reflect;

class Container{ 
	
}

public class TestClass01 {

	public static void main(String[] args) throws ClassNotFoundException {
		//类对象(字节码对象)此对象会在类加载时被创建
		//类对象中映射的是类结构信息(字节码信息)
		//类对象不同于类的对象
		Class c1=Container.class;//类对象
		Class c2=Class.forName("com.java.reinforce.reflect.Container");
		Container con=new Container();//类的实例(类的对象)
		Class c3=con.getClass();
		//一个JVM类对象只有一份
		System.out.println("c1"+c1);
		System.out.println("c2"+c2);
		System.out.println("c3"+c3);
		System.out.println(c1==c2);//true
		
		
		
		
		
		
		
		
		


	}			
}