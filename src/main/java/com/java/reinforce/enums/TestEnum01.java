package com.java.reinforce.enums;

enum Gender{//Gender.class
 MALE,FAMALL,NONE;//ö�ٵ�����ʵ��
 private Gender() {//����д,����˽�л�
	 System.out.println("Gender");
 }
 
}
class Product{
	/** �Ա�Ҫ��*/
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
