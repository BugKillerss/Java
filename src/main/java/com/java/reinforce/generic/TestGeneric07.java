package com.java.reinforce.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
class A{
	void a() {};
}
class B extends A{
	void b() {
	}
}

public class TestGeneric07 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		//�������
		A a=new A(); 
		a.a();
		//a.b()����:��Ϊ������������෽����Ҫǿת
		A a1=new B();
		a1.a();
		//a1.b()����
		//((B)a).b();


		List<String> list1=new ArrayList<String>();
		list1.add("A");
		list1.add("B");
		//list1.add(100)
		//��ҵ:���ڸ�λѧ���ķ��佫100��ӵ�������
		Class c1=list1.getClass();
		java.lang.reflect.Method name=c1.getDeclaredMethod("add",Object.class);//��������
		//����invoke()���
		name.invoke(list1,100);
		name.invoke(list1,true);
		System.out.println(list1);
		





















	}



}
