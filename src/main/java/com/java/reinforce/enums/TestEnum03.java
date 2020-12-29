package com.java.reinforce.enums;
enum ExcutorType{
	SIMPLE,CACHE;//类的实例(类加载时创建),必须在第一行

	static {
		System.out.println("Static");		
	}

	private ExcutorType() {
		System.out.println("ExcutorType");
	}
}


public class TestEnum03 {
public static void main(String[] args) {
	//1.
	ExcutorType ex=ExcutorType.SIMPLE;
	
	
	
}
	
}
