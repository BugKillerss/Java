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
	msg.setTitle("中国");
	msg.setContent("反序列化");
	msg.setCreatedTime("2019-2-28");
	ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("M.txt"));
	os.writeObject(msg);
	System.out.println("执行完毕!");

	ObjectInputStream io=new ObjectInputStream(new FileInputStream("M.txt")); 
	Massage m=(Massage) io.readObject();//也可以用Object接收
	System.out.println(m);
	
	
}
	
}
