package com.java.reinforce.generic;
/**
 * 类泛型:只能应用与实例方法,不能应用于静态方法
 * @author Administrator
 *
 */
class ClassUtil<T>{
	public T newInstance(Class<T> clazz) {//泛型类方法不同于泛型方法
		return null;
	}
	/**
	 * 泛型方法:可以是静态方法,也可以是实例方法
	 *方法上的泛型只能作用域当前方法
	 * @param t
	 * @return 
	 */
	public static <E>void print(E t){ 
		System.out.println(t);
		
	}
	
	}
public class TestGeneric04 {
	public static void main(String[] args) {
		ClassUtil<String> cls=new ClassUtil<String>();
		String s=cls.newInstance(String.class);
		System.out.println(s);


		
		
	}
	

	
}
