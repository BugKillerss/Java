package com.java.reinforce.enums;
//enum ö��
enum Sex{
	//ö�����͵Ķ������������ʱ����
	MALE("��"),FEMALL("Ů");
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
		//���ַ���ת��Ϊö������ʱ,�ַ�����ֵ
		//��ö�����е�ʵ������ͬ.
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
