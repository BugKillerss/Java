package com.java.reinforce.generic;

import java.util.ArrayList;
import java.util.List;

/***
 * List<Object> list1=new ArrayList<String>();  x
 * List<String> list1=new ArrayList<Object>();  X
 * @author Administrator
 */

public class TestGeneric06 {

		public static void main(String[] args) {
			Method01();
			ArrayList<String> lis1=new ArrayList<String>();
			lis1.add("A");lis1.add("B");
			Method02(lis1);
			ArrayList<StringBuffer> lis2=new ArrayList<StringBuffer>();
			StringBuffer sb=new StringBuffer();
			sb.append("C").append("D");
			lis2.add(sb);
			Method02(lis2);

		}

		//����˷����������һ��List��������
		//������ֻ�������ַ�����ص�����
		public static void Method02(ArrayList<? extends Object> lis1) {
			System.out.println(lis1);	
			
			
		}
		///
		private static void Method01() {
			//ָ�������Ͻ�
			List<? extends Object> list1=new ArrayList<String>();
			//list1.add("1000")����
			list1.add(null);
			//ָ�������½�
			List<? super String> list2=new ArrayList<Object>();
			//list2.add(2000);����
			list2.add("1000");
		}
		
		
	
}
