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

		//定义此方法用于输出一个List集合内容
		//其内容只能是与字符串相关的类型
		public static void Method02(ArrayList<? extends Object> lis1) {
			System.out.println(lis1);	
			
			
		}
		///
		private static void Method01() {
			//指定对象上届
			List<? extends Object> list1=new ArrayList<String>();
			//list1.add("1000")错误
			list1.add(null);
			//指定对象下届
			List<? super String> list2=new ArrayList<Object>();
			//list2.add(2000);错误
			list2.add("1000");
		}
		
		
	
}
