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
	
	//��������ֽ�����󴴽����ʵ������
	private static <T>T doCreateInstance(Class<T> cls) throws Exception {
		//1.��ȡ���еĹ��췽������
		Constructor<T> con=cls.getDeclaredConstructor();
		con.setAccessible(true);///���ÿɼ�
		//2.���ڹ��췽�����󹹽����ʵ������
		return con.newInstance();
		
	}

	private static void doLoadClass() throws ClassNotFoundException {
		//1.�����(�ֽ������)��ȡ
		//Class<Point> c1=Point.class;//��������ز���ִ�о�̬�����
		Class<?> c2=Class.forName("com.java.reinforce.reflect.Point");
		//Class<?> c3=new Point().getClass();
	}
}
