package com.java.reinforce.reflect;
class Static{
	static {
		System.out.println("Static");
	}
}

public class Teststatic04 {
	public static void main(String[] args) throws ClassNotFoundException {
		//�����ʱ��һ������ؾ�̬�����,��������ʾ���ػ�����ʽ����
		//��ʾ����:��ʽ1
		Class.forName("com.java.reinforce.reflect.Static");
		System.out.println("���ط�ʽ1");
		
		//��ʾ����:��ʽ2
		//ClassLoader loader=ClassLoader.getSystemClassLoader();
		//loader.loadClass("Static");
		
		//��ʾ����:��ʽ3
		ClassLoader loader=ClassLoader.getSystemClassLoader();
		Class.forName("com.java.reinforce.reflect.Static",true,loader);
		//Ϊtrueʱ,����ؾ�̬�����,Ϊfalseʱ,������ؾ�̬�����
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
