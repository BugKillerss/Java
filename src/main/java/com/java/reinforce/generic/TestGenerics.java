package com.java.reinforce.generic;

interface Task1<Param,Result>{
	Result execute(Param arg);
}

class Async implements Task1<Integer,Integer>{

	public Integer execute(Integer arg) {
		int result=0;
		for(int i=0;i<=arg;i++) {
			if(i%2!=0) {
				result+=i;
			}
		}
		return result;
	}
}

abstract class Method<Param,Result> implements Task1<Param,Result>{
	public abstract Result execute(Param arg);
}

public class TestGenerics {

	public static void main(String[] args) {
		Async ac=new Async();
		Integer i=ac.execute(10);
		System.out.println(i);
		
		Method<String,Integer> m=new Method<String,Integer>() {
			@Override
			public Integer execute(String arg) {
				
				return Integer.parseInt(arg);
			}
		};

	}
}
