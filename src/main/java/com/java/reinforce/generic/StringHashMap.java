package com.java.reinforce.generic;

import java.util.HashMap;

public class StringHashMap<V> extends HashMap<String,V>{
	@Override
	public V put(String arg0, V arg1) {
		return super.put(arg0, arg1);
	}
	@Override
	public V get(Object arg0) {
		return super.get(arg0);
	}
	public static void main(String[] args) {
		StringHashMap<Integer> map=new StringHashMap<Integer>();
		map.put("1", 5);
	
	
		
	}

	
}








