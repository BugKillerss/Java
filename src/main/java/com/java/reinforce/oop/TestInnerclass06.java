package com.java.reinforce.oop;
/**
 * ��Ϊ�ڲ���?���ж������,������
 *1.�޶����ʷ�Χ,ͬʱҲ���ԶԾֲ����Խ��з�װ
 *2.���Է����ⲿ���Ա(�ܷ�����Щ��Ա��Ҫ�����ڲ����)
 * @author Administrator
 */
class Outer{
	class Inner01{} //ʵ���ڲ���
	
static class Inner02{}//��̬�ڲ���

public void creat() {	
	class Inner03{}//�ֲ��ڲ���
}

private Runnable Inner04=new Runnable() {//�����ڲ���,��������ʱ,���ʼ��
	@Override
	public void run() {
	}
};


}

public class TestInnerclass06 {

}
