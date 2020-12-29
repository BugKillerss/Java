package com.java.reinforce.model.Singleton;
class Singleton01{
	///使用此类的目的是要实现外部类对象的延迟加载(对象不使用时,尽量不要占用内存)
	static class Inner{//静态内部类
		private static Singleton01  Instance=new Singleton01();
	}
	
	//private byte[] b= new byte[1024*1024*10];
	private Singleton01() {}
	
	public static Singleton01 getInstance() {
		return Inner.Instance;
	}
	//静态方法
	public static void show() {};
	//实例方法
	public void display() {};
}
public class TeastModel {
public static void main(String[] args) {
	//1.不允许外界构建某个对象,请问如何设计?
	//2.设计实现
	//2.1构造方法私有化
	//2.2类加载时创建对象
	//2.3提供可访问的惊天方法用于用于返回创建的实例
	
	Singleton01 Instance=Singleton01.getInstance();
	Instance.display();
	Singleton01.show();
	
	//3如何在调用Singleton类中show()时,Singleton中的对象不会被自动创建(自动创建会使内存泄漏).
	//优化设计.
	//3.1将对象的创建放在静态内部类中,静态类不会被加载,静态类不会被创建
	
	
	
	
	
	
	
	

}
	

}
