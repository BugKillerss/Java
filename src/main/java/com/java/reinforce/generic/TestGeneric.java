package com.java.reinforce.generic;
/**
 * ����:1.���Ϳ�����߳���������.
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Container<T>{//�෺��:����:����
	
	public void add(T t) {}//ͨ������Լ����������
	public T get() {//ͨ������Լ������ֵ����
		return null;
		}
}

public class TestGeneric {

	public static void main(String[] args) {
		//��ݼ�
		//ctrl+shift+o���ٽ���ָ�����е���
		//alt+shift+Mѡ�з�Χ������ȡ�ɷ���
		//Method01();
		
	}

	private static void Method01() {
		List list0=new ArrayList();
		List<String> list1=new ArrayList();
		List<String> list2=new ArrayList();//JDK1.7
		ArrayList<Integer> list3=new ArrayList();
		list0.add("123");
		Collections.synchronizedList(list1);
		
		String s=(String) list0.get(0);//ǿת��������ʱӰ������
		//���Ͳ����������������,һ��д���Ǵ����
		//List<boolean> list4=new ArrayList();
		List<Boolean> list5=new ArrayList();//��ȷ.�������ͱ����Ƕ�������
	}

		public static void Method02() {
			Container c=new Container();
			c.add(123);
			c.add("123");
			
			
		}
		
		
	}
	
	
