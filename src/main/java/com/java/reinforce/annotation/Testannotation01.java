package com.java.reinforce.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//????????????
@Target(ElementType.TYPE)//????????????
@interface Entity{}

@Target({ElementType.TYPE,ElementType.METHOD})//??????????????
@interface RequestMapping{
	//???????????
	String value() default "";
}

@Target(ElementType.FIELD)//??????????????
@interface ID{}

@Entity
class SysLog{
	@ID
	private Integer id;
	@RequestMapping("/")
	public void set() {
	}
}

public class Testannotation01 {



}
