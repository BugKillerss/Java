package com.java.reinforce.statics;

import java.util.HashMap;
import java.util.Map;
//此类考察静态属性的位置顺序影响加载顺序问题.
class Simple{
	public static Simple s=new Simple();
	public static Map<String,Integer> map=new HashMap<String, Integer>();
	private Simple() {
		map.put("key1",100);
		map.put("key2",200);
	}
	
}

public class Teststatic02 {
public static void main(String[] args) {
	System.out.println(Simple.s.map);
	//空指针异常,原因:先加载的是构造方法,然后往map内存值,
	//但是此时并为创建map,所以放不进去,空值.
	
	//解决方法
	//将map的创建放在Simple对象创建的前面,让类先加载map.
	
	
	
	
}
}
