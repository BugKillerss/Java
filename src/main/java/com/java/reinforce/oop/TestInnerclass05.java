package com.java.reinforce.oop;

abstract class ClassE{
	abstract void E();
}

abstract class ClassF extends ClassE{
	abstract void F();
}

public class TestInnerclass05 {
	public static void main(String[] args) {
		//��������ָ���������
		ClassE f=new ClassF() {//ClassF���������
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
		//f.F();����
		
		
		
		
		
		
		
		
		
		
		
				
				


	}


}
