package com.java.reinforce.generic;
/**
 * �෺��:ֻ��Ӧ����ʵ������,����Ӧ���ھ�̬����
 * @author Administrator
 *
 */
class ClassUtil<T>{
	public T newInstance(Class<T> clazz) {//�����෽����ͬ�ڷ��ͷ���
		return null;
	}
	/**
	 * ���ͷ���:�����Ǿ�̬����,Ҳ������ʵ������
	 *�����ϵķ���ֻ��������ǰ����
	 * @param t
	 * @return 
	 */
	public static <E>void print(E t){ 
		System.out.println(t);
		
	}
	
	}
public class TestGeneric04 {
	public static void main(String[] args) {
		ClassUtil<String> cls=new ClassUtil<String>();
		String s=cls.newInstance(String.class);
		System.out.println(s);


		
		
	}
	

	
}
