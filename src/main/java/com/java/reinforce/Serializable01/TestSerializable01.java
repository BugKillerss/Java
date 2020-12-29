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

class SysLog implements Serializable{//���л��ӿ�ֻ��һ����־������,ϵͳ�ײ�������Ľṹ�Զ�����һ����.
	/**���л��汾��*/
	private static final long serialVersionUID = 4976850959997288891L;
	/**��־*/
	private Integer id;//������ǰ�����transient,�����л�ʱ�����Բ��ᱻ����
	/**�����û�*/
	private String username;
	//����Ľṹ�����ı�,����û��������л��汾��,
	//��ʹ�����л��쳣(���л��ͷ����л���Ҫͬʱ����,����ûӰ��)
	private Date date;

	private void writeObject(ObjectOutputStream oos) throws IOException {//�÷����������л�ʱ�Զ���ִ��
		System.out.println("1");
		//1.��ȡһ�����ܶ���
		Encoder encoder=Base64.getEncoder();//Base64
		//2.�����ݽ��м���
		byte[] data=encoder.encode(username.getBytes());		
		//3.�����ܽ�����¸�ֵ��username
		username=new String(data);
		//4.ִ��Ĭ�����л�
		oos.defaultWriteObject();//���л�

	}
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {//�÷����������л�ʱ�Զ���ִ��
		//1.ִ�����л�
		ois.defaultReadObject();
		System.out.println("2");
		//2.��ȡһ�����ܶ���
		Decoder decoder=Base64.getDecoder();
		//3.���ļ����ݽ��н���
		byte[] data=decoder.decode(username.getBytes());
		//3.�������������¸��Ƹ�username
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
		//1.������־����,�洢����
		SysLog log=new SysLog();
		log.setId(1);
		log.setUsername("����");
		//2.�������������,����־����洢���ļ�
		ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("IO.txt"));
		os.writeObject(log);
		System.out.println("ִ�����!");

		ObjectInputStream io=new ObjectInputStream(new FileInputStream("IO.txt")); 
		SysLog sys=(SysLog) io.readObject();//Ҳ������Object����
		System.out.println(sys);


	}
}
