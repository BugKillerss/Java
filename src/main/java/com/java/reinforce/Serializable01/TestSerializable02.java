package com.java.reinforce.Serializable01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializable02 {
public static void main(String[] args) throws IOException, ClassNotFoundException {
	Massage msg=new Massage();
	msg.setId(1);
	msg.setTitle("�й�");
	msg.setContent("�����л�");
	msg.setCreatedTime("2019-2-28");
	ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("M.txt"));
	os.writeObject(msg);
	System.out.println("ִ�����!");

	ObjectInputStream io=new ObjectInputStream(new FileInputStream("M.txt")); 
	Massage m=(Massage) io.readObject();//Ҳ������Object����
	System.out.println(m);
	
	
}
	
}
