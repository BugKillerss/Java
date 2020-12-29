package com.java.reinforce.enums;

enum Gender{//Gender.class
 MALE,FAMALL,NONE;//枚举的三个实例
 private Gender() {//假如写,必须私有化
	 System.out.println("Gender");
 }
 
}
class Product{
	/** 性别要求*/
	private Gender gender=Gender.NONE;
	public void setGender(Gender gender) {
		this.gender=gender;
	}
}

public class TestEnum01 {
public static void main(String[] args) {
	Product p=new Product();
	p.setGender(Gender.FAMALL);
	Gender gender=Gender.NONE;
	
}
	
}
