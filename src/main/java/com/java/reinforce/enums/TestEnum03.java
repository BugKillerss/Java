package com.java.reinforce.enums;
enum ExcutorType{
	SIMPLE,CACHE;//���ʵ��(�����ʱ����),�����ڵ�һ��

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
