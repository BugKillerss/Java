package com.java.reinforce.reflect;

class Container{ 
	
}

public class TestClass01 {

	public static void main(String[] args) throws ClassNotFoundException {
		//�����(�ֽ������)�˶�����������ʱ������
		//�������ӳ�������ṹ��Ϣ(�ֽ�����Ϣ)
		//�����ͬ����Ķ���
		Class c1=Container.class;//�����
		Class c2=Class.forName("com.java.reinforce.reflect.Container");
		Container con=new Container();//���ʵ��(��Ķ���)
		Class c3=con.getClass();
		//һ��JVM�����ֻ��һ��
		System.out.println("c1"+c1);
		System.out.println("c2"+c2);
		System.out.println("c3"+c3);
		System.out.println(c1==c2);//true
		
		
		
		
		
		
		
		
		


	}			
}