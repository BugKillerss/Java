package com.java.reinforce.oop;
//������
class ClassA{
	int a=10;
	static int b=6;
	public void show() {

	}
}
//������
abstract class ClassB{
	 abstract void show();

}
//�ӿ�
interface ClassC{ 
	void show();//Ĭ��ʹ��public abstract

}
public class TestInnerclass04 {
	public static void main(String[] args) {
		ClassA ca=new ClassA();
		//ClassB cb=new ClassB();����
		//ClassC cc=new ClassC();����
		//����ָ�����͵��������ͻ�ʵ�������
		//1.����ClassA���͵��������
		//2.����ClassB���͵��������
		//3.����ClassC���͵��������
		ClassA aa=new ClassA() {
			int c=10;
			//�˴�������д���෽��,Ҳ���Դ�����������
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
				//super.show();����:��Ϊsuperָ����Ķ���,������Ϊ������,û�ж���,���Դ���
			}		
		};

		ClassC cc=new ClassC() {//�ӿڻ�������еĳ��󷽷�һ��Ҫ����д
			@Override
			public void show() {
			}
		};


	}




}
