package com.java.reinforce.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象的处理器(负责处理具体业务)
 */
class ProxyHandler implements InvocationHandler{
	private Object target;
	public ProxyHandler(Object target) {
		this.target=target;
	}
	/**
	 * 当执行代理对象方法时,底层会调用invoke方法执行
	 * 此方法中的业务:
	 * 1)添加扩展功能
	 * 2)执行目标业务
	 * @param proxy 指向代理对象
	 * @param method 目标接口方法
	 * @param args 执行目标接口方法时传入的实际参数值
	 */
	public Object invoke(Object proxy,
			Method method, Object[] params) throws Throwable {
		long t1=System.nanoTime();
		//执行目标对象target的method方法
		Object result=method.invoke(target,params);
		long t2=System.nanoTime();
		System.out.println("total time "+(t2-t1));
		return result;
	}
}
/**
 * 为某个目标对象创建代理对象的工厂.
 * 目的:基于代理对象扩展目标对象功能并且可以控制目标
 */
public class ProxyFactory{
	/**
	 * 为目标对象创建代理对象
	 * @param target 目标对象 (必须实现了接口)
	 * @return
	 */
	public static Object newProxy(Object target){
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),//loader
				target.getClass().getInterfaces(),//interfaces
				new ProxyHandler(target));//handler
	}

}
