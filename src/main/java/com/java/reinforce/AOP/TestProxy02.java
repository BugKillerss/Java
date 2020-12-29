package com.java.reinforce.AOP;
public class TestProxy02 {

	public static void main(String[] args) {
	    //1.构建目标对象
		SearchServiceImpl target=new SearchServiceImpl();
		//2.为目标对象创建代理对象
		SearchService service=(SearchService)
		ProxyFactory.newProxy(target);
		System.out.println(service.getClass().getName());
		//3.执行代理对象方法
		Object result=service.search("kairui");
		System.out.println(result);
		
	}
}
