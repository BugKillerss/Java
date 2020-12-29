package com.java.reinforce.AOP;
/**
 * 通过集成实现扩展:
 * 1)优势:可读性好
 * 2)劣势:
 * a)耦合性(子类与父类之间的耦合)
 * b)代码量或工作量会比较大
 * c)父类假如使用了final修饰则不允许继承.
 */
public class ChildSearchServiceImpl extends SearchServiceImpl {
	@Override
	public Object search(String key) {
		long t1=System.nanoTime();
		Object result=super.search(key);
		long t2=System.nanoTime();
		long t=t2-t1;
		System.out.println("total time "+t);
		return result;
	}
}
