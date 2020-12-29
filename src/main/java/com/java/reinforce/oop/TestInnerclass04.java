package com.java.reinforce.oop;
//具体类
class ClassA{
	int a=10;
	static int b=6;
	public void show() {

	}
}
//抽象类
abstract class ClassB{
	 abstract void show();

}
//接口
interface ClassC{ 
	void show();//默认使用public abstract

}
public class TestInnerclass04 {
	public static void main(String[] args) {
		ClassA ca=new ClassA();
		//ClassB cb=new ClassB();错误
		//ClassC cc=new ClassC();错误
		//构建指定类型的子类类型或实现类对象
		//1.构建ClassA类型的子类对象
		//2.构建ClassB类型的子类对象
		//3.构建ClassC类型的子类对象
		ClassA aa=new ClassA() {
			int c=10;
			//此处可以重写父类方法,也可以创建其他方法
			@Override
			public void show() {
				super.show();
				System.out.println(c);
				System.out.println(a);
			}
		};
		aa.show();

		ClassB cb=new ClassB() {
			@Override
			public void show() {
				//super.show();错误:因为super指向父类的对象,而父类为抽象类,没有对象,所以错误
			}		
		};

		ClassC cc=new ClassC() {//接口或抽象类中的抽象方法一定要被重写
			@Override
			public void show() {
			}
		};


	}




}
