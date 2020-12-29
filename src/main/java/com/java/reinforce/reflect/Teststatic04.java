package com.java.reinforce.reflect;
class Static{
	static {
		System.out.println("Static");
	}
}

public class Teststatic04 {
	public static void main(String[] args) throws ClassNotFoundException {
		//类加载时不一定会加载静态代码块,无论是显示加载还是隐式加载
		//显示加载:方式1
		Class.forName("com.java.reinforce.reflect.Static");
		System.out.println("加载方式1");
		
		//显示加载:方式2
		//ClassLoader loader=ClassLoader.getSystemClassLoader();
		//loader.loadClass("Static");
		
		//显示加载:方式3
		ClassLoader loader=ClassLoader.getSystemClassLoader();
		Class.forName("com.java.reinforce.reflect.Static",true,loader);
		//为true时,会加载静态代码块,为false时,不会加载静态代码块
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
