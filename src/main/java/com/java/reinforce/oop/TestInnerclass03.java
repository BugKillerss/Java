package com.java.reinforce.oop;


class Outer03{
	int a;
	int b;
	public void create() {
		/*
		 * �ֲ��ڲ���
		 * 1.λ��:�����ڲ�
		 * 2.����:����ʹ��static����,����ʹ�÷������η�
		 * 3.  Ӧ��:ֻ���ڷ����ڲ�
		 */
		class Inner03{
			//�����в������徲̬��Ա
			//static int cc=200;
			int c=100;
			public void display() {
				System.out.println(this);
				System.out.println(Outer03.this);
			}
		}
		//ֻ���ڷ����ڲ�ʹ�ô˶���
		new Inner03().display();
	}
}

public class TestInnerclass03 {
	public static void main(String[] args) {
		Outer03 out=new Outer03();
		out.create();
		
	}
	
	





}
