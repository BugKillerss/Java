package com.java.reinforce.statics;

import java.util.HashMap;
import java.util.Map;
//���࿼�쾲̬���Ե�λ��˳��Ӱ�����˳������.
class Simple{
	public static Simple s=new Simple();
	public static Map<String,Integer> map=new HashMap<String, Integer>();
	private Simple() {
		map.put("key1",100);
		map.put("key2",200);
	}
	
}

public class Teststatic02 {
public static void main(String[] args) {
	System.out.println(Simple.s.map);
	//��ָ���쳣,ԭ��:�ȼ��ص��ǹ��췽��,Ȼ����map�ڴ�ֵ,
	//���Ǵ�ʱ��Ϊ����map,���ԷŲ���ȥ,��ֵ.
	
	//�������
	//��map�Ĵ�������Simple���󴴽���ǰ��,�����ȼ���map.
	
	
	
	
}
}
