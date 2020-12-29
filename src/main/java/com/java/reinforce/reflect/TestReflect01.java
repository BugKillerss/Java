package com.java.reinforce.reflect;
import java.lang.reflect.Constructor;

class Point{
	 private int x;
	 private int y;

	private Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	static {	
		System.out.println("static");	
	}
}

public class TestReflect01 {
	public static void main(String[] args) throws Exception  {
		doLoadClass();
		Point p=doCreateInstance(Point.class);
		
	}
	
	//基于类的字节码对象创建类的实例对象
	private static <T>T doCreateInstance(Class<T> cls) throws Exception {
		//1.获取类中的构造方法对象
		Constructor<T> con=cls.getDeclaredConstructor();
		con.setAccessible(true);///设置可见
		//2.基于构造方法对象构建类的实例对象
		return con.newInstance();
		
	}

	private static void doLoadClass() throws ClassNotFoundException {
		//1.类对象(字节码对象)获取
		//Class<Point> c1=Point.class;//此种类加载不会执行静态代码块
		Class<?> c2=Class.forName("com.java.reinforce.reflect.Point");
		//Class<?> c3=new Point().getClass();
	}
}
