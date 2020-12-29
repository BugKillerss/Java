package com.java.reinforce.enums;
//enum 枚举
enum Sex{
	//枚举类型的对象是在类加载时创建
	MALE("男"),FEMALL("女");
	private String name;
	private Sex(String name) {
		this.name=name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

class Member{
	private Sex sex=Sex.FEMALL;
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
}
public class TestEnum02 {
	public static void main(String[] args) {
		Member m=new Member();
		m.setSex(Sex.FEMALL);
		System.out.println(m.getSex());
		//将字符串转换为枚举类型时,字符串的值
		//与枚举类中的实例名相同.
		String sex="MALE";
		m.setSex(Sex.valueOf(sex));
		System.out.println(m.getSex());
		//
		Sex[] values=Sex.values();
		for(Sex value:values) {
			System.out.println(value);
		}
				
				
				
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
