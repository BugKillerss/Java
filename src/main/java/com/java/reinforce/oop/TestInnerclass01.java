package com.java.reinforce.oop;

import com.java.reinforce.oop.Outer01.Inner01;
//ע��:
//һ��.java����ֻ�������һ����public���ε���,���ұ����ε���Ҫ��������ͬ
//��̬�����ڲ�ֻ�ܷ���ͬһ�����еľ�̬����
//����ʵ���ڲ������Ĵ���,Ӧ�����ⲿ�����,�����ڲ������
//����ʵ���ڲ����������ⲿ������һ������
class Outer01{
	int a;
	static int b;
	/**
	 * ʵ���ڲ���
	 * 1.λ��:����ڲ�,�������ⲿ
	 * 2.û��static����,���ʿ��Ʒ�����
	 * 3.Ӧ��:�������ⲿ�����,���Է����ⲿ�����г�Ա
	 */
	class Inner01{
		public void display() {
			System.out.println(this);
			System.out.println(Outer01.this);
			System.out.println(a);
			System.out.println(b);
		}
	}
	public void create() {
		this.new Inner01().display();
		//����this����ʡ��
		     new Inner01().display();
	}
}

public class TestInnerclass01 {
	public static void main(String[] args) {
		Outer01 out=new Outer01() ;
		Inner01 in=out.new Inner01();
		in.display();
		//
		Inner01 inner=out.new Inner01();
		inner.display();
	
		



	}





}
