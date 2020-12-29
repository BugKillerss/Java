package com.java.reinforce.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ClassPathXmlApplicationContext {
	//
	public static Map<String,Object> instancemap=new HashMap<String,Object>();
	//
	public static Map<String,BeanDefined> beanmap=new HashMap<String,BeanDefined>();

	public ClassPathXmlApplicationContext(String name) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//1.??????
		InputStream in=this.getClass().getClassLoader().getResourceAsStream(name);

		//----2.???????
		//(1.????DocumentBuilderFactory????
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		//(2.????DocumentBuilder????
		DocumentBuilder builder=factory.newDocumentBuilder();
		//(3.????Document????
		Document doc=builder.parse(in);
		//(4.???xml???????
		NodeList list=doc.getElementsByTagName("bean");//????????

		for(int i=0;i<list.getLength();i++) {
			Node node=list.item(i);//?????
			NamedNodeMap map1=node.getAttributes();//????????????
			BeanDefined bd=new BeanDefined();

			for(int j=0;j<map1.getLength();j++){
				Node node1=map1.item(j);
				//??????
				if(node1.getNodeName().equalsIgnoreCase("id")) {
					bd.setId(node1.getNodeValue());
				}else if(node1.getNodeName().equalsIgnoreCase("class")) {
					bd.setClassName(node1.getNodeValue());
				}else if(node1.getNodeValue().equalsIgnoreCase("lazy")) {
					bd.setLazy(Boolean.valueOf(node1.getNodeValue()));
				}
			}
			//??beans???????
			beanmap.put(bd.getId(),bd);
			System.out.println(bd);
			if(!bd.getLazy()) {
				Object obj=newInstance(bd.getClassName());
				//??bean?????
				instancemap.put(bd.getId(),obj);
			}
		}

	}

	private Object newInstance(String cs) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> cls=Class.forName(cs);
		Constructor<?> con=cls.getDeclaredConstructor();
		return con.newInstance();
	}
	//3.??????????????????(????)
	public <T>T getBean(String id,Class<T> cls) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//1.??Bean?????map????????,??????????
		Object obj=instancemap.get(id);
		if(obj!=null) return (T)obj;
		//???instancemap????????,?????bean????????
		BeanDefined bd=beanmap.get(id);
		try {
			obj=newInstance(bd.getClassName());
			instancemap.put(bd.getId(),obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (T)obj;

	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ClassPathXmlApplicationContext ac=new  ClassPathXmlApplicationContext("beans.xml");
		Pointer p=ac.getBean("pointer",Pointer.class);
		System.out.println(p);

		
	}


}
