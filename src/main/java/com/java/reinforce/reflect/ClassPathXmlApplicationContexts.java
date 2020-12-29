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

public class ClassPathXmlApplicationContexts {
	//用来存储getBean对象
	private Map<String,Object> instancemap=new HashMap<String,Object>();

	//用来存储配置对象
	private Map<String,BeanDefined> beanmap=new HashMap<String,BeanDefined>();

	public ClassPathXmlApplicationContexts(String file) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException { 
		//1.读取文件
		InputStream in=	this.getClass().getClassLoader().getResourceAsStream(file);
		//2.解析文件
		//(1创建DocumentFactory对象
		DocumentBuilderFactory docfactory=DocumentBuilderFactory.newInstance();
		//(2.创建DocumentBuilder对象
		DocumentBuilder docBuilder=docfactory.newDocumentBuilder();
		//(3.创建Document对象
		Document doc=docBuilder.parse(in);
		NodeList list=doc.getElementsByTagName("bean");//获取bean标签
		for(int i=0;i<list.getLength();i++) {
			Node node=list.item(i);
			NamedNodeMap nodemap=node.getAttributes();//遍历每一个bean标签
			//创建BeanDefined对象,用来存储beans.xml中每一个bean标签信息
			BeanDefined bd=new BeanDefined();
			for(int j=0;j<nodemap.getLength();j++) {
				Node node1=nodemap.item(j);
				if(node1.getNodeName().equalsIgnoreCase("id")) {
					bd.setId(node1.getNodeValue());
				}else if(node1.getNodeName().equalsIgnoreCase("class")) {
					bd.setClassName(node1.getNodeValue());
				}else {
					bd.setLazy(Boolean.valueOf(node1.getNodeValue()));
				}
			}

			beanmap.put(bd.getId(),bd);
			if(!bd.getLazy()) {//如果lazy为false
				Object obj=newInstance(bd.getClassName());
				instancemap.put(bd.getId(),obj);
			}
		}

	}


	private Object newInstance(String cls) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> c=Class.forName(cls);
		Constructor<?> con=c.getConstructor();
		return con.newInstance();
	}

	public <T>T getBean(String name) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Object obj=instancemap.get(name);
		if(obj!=null) return (T) obj;//如果不为空值则返回
		//如果为空值则创建新对象
		BeanDefined bd=beanmap.get(name);
		obj=newInstance(bd.getClassName());
		instancemap.put(bd.getId(),obj);
		return (T) obj;
	}


	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ClassPathXmlApplicationContexts ac=new ClassPathXmlApplicationContexts("beans.xml");
		Pointer p=ac.getBean("pointer");
		System.out.println(p);
	}
}
