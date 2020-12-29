package com.java.reinforce.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)//������������Ч
@Target(ElementType.TYPE)//��ʾֻ��������
@interface Service{
	String value() default "";
}

@Service("/hello")
class SysLogs{}

public class Testannotation02 {
	 static Map<String,Object> map=new HashMap<String,Object>(); 
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//��μ��SysLogs�����Ƿ���@Service
		Class<?> cls=SysLogs.class;
		newInstance(cls);
		SysLogs s1=getBean("/hello");
		System.out.println(s1);
	}

	private static <T>T getBean(String s) {
		
		return (T)map.get(s);
	}

	private static void newInstance(Class<?> cls) throws InstantiationException, IllegalAccessException {
		//�ж�SysLogss�Ƿ���ע��
		boolean flag=cls.isAnnotationPresent(Service.class);
		//������ע�����ȡע�������
		if(!flag) return;
		Service service=cls.getDeclaredAnnotation(Service.class);
		System.out.println("service:"+service);
		String key=service.value();
		Object obj=cls.newInstance();
		map.put(key,obj);

	}
}