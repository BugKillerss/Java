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
		//2.��������õ��ø���ľ�̬����ʱ,����Ϊ�𶯼���,
		//����Ϊ��������,�������ص���,�侲̬���벻��ִ��
		System.out.println(Static02.a);
	}
}
