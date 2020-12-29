package com.java.reinforce.generic;

import java.util.ArrayList;

public class SynchronizedArrayList<E> extends ArrayList<E>{
	@Override
	public synchronized boolean add(E e) {
		// TODO Auto-generated method stub
		return super.add(e);
	}
	
	@Override
	public synchronized E get(int index) {
		// TODO Auto-generated method stub
		return super.get(index);
	}
}



