package com.java.reinforce.reflect;

public class BeanDefined {
	private String id;
	private String className;
	private Boolean lazy=false;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Boolean getLazy() {
		return lazy;
	}
	public void setLazy(Boolean lazy) {
		this.lazy = lazy;
	}
	@Override
	public String toString() {
		return "BeanDefined [id=" + id + ", className=" + className + ", lazy=" + lazy + "]";
	}
	
	
	
	
}
