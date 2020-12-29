package com.java.reinforce.generic;
class Log{
}

public class TestGeneric05 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<Log> c1=Log.class;//类对象
		System.out.println(c1.toString());
		//?为泛型应用的通配符,当不确定泛型时,可以看成一中任意的参数类型
		Class<?> c2=Class.forName("com.java.reinforce.generic.Log");
		System.out.println(c2);
		System.out.println(c1==c2);//true
		
		
		
		
		
		
		
		
		
		
	}
	
}
