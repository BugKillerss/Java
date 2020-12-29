package com.java.reinforce.generic;

import java.util.HashMap;

public class SynchronizedHashMap<K,V> extends HashMap<K,V>{
	@Override
	public synchronized V put(K arg0, V arg1) {
		// TODO Auto-generated method stub
		return super.put(arg0, arg1);
	}
	@Override
	public  synchronized V get(Object arg0) {
		// TODO Auto-generated method stub
		return super.get(arg0);
	}
	

}
