package com.java.reinforce.oop;

abstract class ClassE{
	abstract void E();
}

abstract class ClassF extends ClassE{
	abstract void F();
}

public class TestInnerclass05 {
	public static void main(String[] args) {
		//父类引用指向子类对象
		ClassE f=new ClassF() {//ClassF的子类对象
			@Override
			void E() {
				System.out.println("ClassE");
			}
			@Override
			void F() {
				System.out.println("ClassF");
			}
		};
		f.E();
		//f.F();错误
		
		
		
		
		
		
		
		
		
		
		
				
				


	}


}
