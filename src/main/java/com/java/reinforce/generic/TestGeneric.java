package com.java.reinforce.generic;
/**
 * 泛型:1.泛型可以提高程序的灵活性.
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Container<T>{//类泛型:类名:泛型
	
	public void add(T t) {}//通过泛型约束参数类型
	public T get() {//通过泛型约束返回值类型
		return null;
		}
}

public class TestGeneric {

	public static void main(String[] args) {
		//快捷键
		//ctrl+shift+o快速进入指定报中的类
		//alt+shift+M选中范围代码提取成方法
		//Method01();
		
	}

	private static void Method01() {
		List list0=new ArrayList();
		List<String> list1=new ArrayList();
		List<String> list2=new ArrayList();//JDK1.7
		ArrayList<Integer> list3=new ArrayList();
		list0.add("123");
		Collections.synchronizedList(list1);
		
		String s=(String) list0.get(0);//强转会在运行时影响性能
		//泛型不允许基本数据类型,一下写法是错误的
		//List<boolean> list4=new ArrayList();
		List<Boolean> list5=new ArrayList();//正确.泛型类型必须是对象类型
	}

		public static void Method02() {
			Container c=new Container();
			c.add(123);
			c.add("123");
			
			
		}
		
		
	}
	
	
