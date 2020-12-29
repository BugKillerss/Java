package com.java.reinforce.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)//定义运行期有效
@Target(ElementType.TYPE)//表示只能描述类
@interface Service{
	String value() default "";
}

@Service("/hello")
class SysLogs{}

public class Testannotation02 {
	 static Map<String,Object> map=new HashMap<String,Object>(); 
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//如何检测SysLogs类上是否有@Service
		Class<?> cls=SysLogs.class;
		newInstance(cls);
		SysLogs s1=getBean("/hello");
		System.out.println(s1);
	}

	private static <T>T getBean(String s) {
		
		return (T)map.get(s);
	}

	private static void newInstance(Class<?> cls) throws InstantiationException, IllegalAccessException {
		//判定SysLogss是否有注解
		boolean flag=cls.isAnnotationPresent(Service.class);
		//假如有注解则获取注解的内容
		if(!flag) return;
		Service service=cls.getDeclaredAnnotation(Service.class);
		System.out.println("service:"+service);
		String key=service.value();
		Object obj=cls.newInstance();
		map.put(key,obj);

	}
}