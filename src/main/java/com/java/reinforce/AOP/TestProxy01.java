package com.java.reinforce.AOP;

public class TestProxy01 {

	public static void main(String[] args) {
		//doMethod01();
		doMethod02();
	}

	private static void doMethod02() {
		SearchService service=null;
		SearchServiceImpl target=new SearchServiceImpl();
		service=new ProxySearchService(target);
		Object result=service.search("tedu");
		System.out.println(result);
	}

	//alt+shift+m
	private static void doMethod01() {
		SearchService service=null;
		//service=new SearchServiceImpl();
		service=new ChildSearchServiceImpl();
		Object result=service.search("tmooc");
		System.out.println(result);
	}
}
