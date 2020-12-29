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
		//面向对象
		A a=new A(); 
		a.a();
		//a.b()错误:因为父类钓不到子类方法需要强转
		A a1=new B();
		a1.a();
		//a1.b()错误
		//((B)a).b();


		List<String> list1=new ArrayList<String>();
		list1.add("A");
		list1.add("B");
		//list1.add(100)
		//作业:基于各位学过的反射将100添加到集合中
		Class c1=list1.getClass();
		java.lang.reflect.Method name=c1.getDeclaredMethod("add",Object.class);//参数类型
		//根据invoke()解决
		name.invoke(list1,100);
		name.invoke(list1,true);
		System.out.println(list1);
		





















	}



}
