package com.java.reinforce.Serializable01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Date;

class SysLog implements Serializable{//序列化接口只起到一个标志的作用,系统底层会基于类的结构自动生成一个号.
	/**序列化版本号*/
	private static final long serialVersionUID = 4976850959997288891L;
	/**日志*/
	private Integer id;//在属性前面加上transient,在序列化时给属性不会被加载
	/**操作用户*/
	private String username;
	//若类的结构发生改变,并且没有添加序列化版本号,
	//会使反序列化异常(序列化和反序列化不要同时进行,否则没影响)
	private Date date;

	private void writeObject(ObjectOutputStream oos) throws IOException {//该方法会在序列化时自动被执行
		System.out.println("1");
		//1.获取一个加密对象
		Encoder encoder=Base64.getEncoder();//Base64
		//2.对内容进行加密
		byte[] data=encoder.encode(username.getBytes());		
		//3.将加密结果重新赋值给username
		username=new String(data);
		//4.执行默认序列化
		oos.defaultWriteObject();//序列化

	}
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {//该方法会在序列化时自动被执行
		//1.执行序列化
		ois.defaultReadObject();
		System.out.println("2");
		//2.获取一个解密对象
		Decoder decoder=Base64.getDecoder();
		//3.对文件内容进行解密
		byte[] data=decoder.decode(username.getBytes());
		//3.将解密内容重新复制给username
		username=new String(data);



	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "SysLog [id=" + id + ", username=" + username + "]";
	}

}


public class TestSerializable01 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//1.构建日志对象,存储数据
		SysLog log=new SysLog();
		log.setId(1);
		log.setUsername("孙珂");
		//2.构建对象输出流,将日志对象存储到文件
		ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("IO.txt"));
		os.writeObject(log);
		System.out.println("执行完毕!");

		ObjectInputStream io=new ObjectInputStream(new FileInputStream("IO.txt")); 
		SysLog sys=(SysLog) io.readObject();//也可以用Object接收
		System.out.println(sys);


	}
}
