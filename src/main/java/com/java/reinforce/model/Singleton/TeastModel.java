package com.java.reinforce.model.Singleton;
class Singleton01{
	///ʹ�ô����Ŀ����Ҫʵ���ⲿ�������ӳټ���(����ʹ��ʱ,������Ҫռ���ڴ�)
	static class Inner{//��̬�ڲ���
		private static Singleton01  Instance=new Singleton01();
	}
	
	//private byte[] b= new byte[1024*1024*10];
	private Singleton01() {}
	
	public static Singleton01 getInstance() {
		return Inner.Instance;
	}
	//��̬����
	public static void show() {};
	//ʵ������
	public void display() {};
}
public class TeastModel {
public static void main(String[] args) {
	//1.��������繹��ĳ������,����������?
	//2.���ʵ��
	//2.1���췽��˽�л�
	//2.2�����ʱ��������
	//2.3�ṩ�ɷ��ʵľ��췽���������ڷ��ش�����ʵ��
	
	Singleton01 Instance=Singleton01.getInstance();
	Instance.display();
	Singleton01.show();
	
	//3����ڵ���Singleton����show()ʱ,Singleton�еĶ��󲻻ᱻ�Զ�����(�Զ�������ʹ�ڴ�й©).
	//�Ż����.
	//3.1������Ĵ������ھ�̬�ڲ�����,��̬�಻�ᱻ����,��̬�಻�ᱻ����
	
	
	
	
	
	
	
	

}
	

}
