package com.java.reinforce.oop;
class Outer02{
	int a;
	static int b;
	/**
	 * ��̬�ڲ���
	 * 1.λ��:����ڲ�,�������ⲿ
	 * 2.����:ʹ��static����,��������������η�
	 * 3Ӧ��:���������ⲿ�����,���Է����ⲿ���еľ�̬����
	 */
	static class Inner02{
		int c;
		static int d;
		//ʵ�������(ÿ�δ�������ʱ����ִ��)
		{
			//a=100;
			b=100;
			c=100;
			d=10;
			System.out.println(this);
			
		}
		//��̬�����,�������ʱ�ᱻִ��,����ֻ��ִ��һ��
		static {
			//a=100;
			b=100;
			//c=10;
			d=20;
			//System.out.println(this);
		}
		
		public void display() {
			System.out.println(b);
			//System.out.println(a);����:��̬���еķ�����ֻ�ܷ��ʾ�̬��Ա,�㲻�ܷ��ʷǾ�̬��Ա
			System.out.println(this);
			//System.out.println(Outer02.this);����
		}
	} 
	public void create() {
		new Inner02().display();
	}
}

public class TestInnerclass02 {
	public static void main(String[] args) {
		//��̬�ڲ��������Ĺ����ķ�ʽ
		Outer02.Inner02 in=new Outer02.Inner02(); 
		
		
	}



}
