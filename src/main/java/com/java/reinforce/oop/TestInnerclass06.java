package com.java.reinforce.oop;
/**
 * 何为内部类?类中定义的类,有四种
 *1.限定访问范围,同时也可以对局部属性进行封装
 *2.可以访问外部类成员(能访问那些成员还要具体内部类的)
 * @author Administrator
 */
class Outer{
	class Inner01{} //实例内部类
	
static class Inner02{}//静态内部类

public void creat() {	
	class Inner03{}//局部内部类
}

private Runnable Inner04=new Runnable() {//隐藏内部类,构建对象时,会初始化
	@Override
	public void run() {
	}
};


}

public class TestInnerclass06 {

}
