package com.java.reinforce.generic;
class Log{
}

public class TestGeneric05 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class<Log> c1=Log.class;//�����
		System.out.println(c1.toString());
		//?Ϊ����Ӧ�õ�ͨ���,����ȷ������ʱ,���Կ���һ������Ĳ�������
		Class<?> c2=Class.forName("com.java.reinforce.generic.Log");
		System.out.println(c2);
		System.out.println(c1==c2);//true
		
		
		
		
		
		
		
		
		
		
	}
	
}
