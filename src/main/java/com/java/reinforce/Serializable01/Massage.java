package com.java.reinforce.Serializable01;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Massage implements Externalizable{
	
	private Integer id;
	private String title;
	private String content;
	private String createdTime;
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(title);
		out.writeInt(id);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		title=in.readUTF();
		id=in.readInt();
		
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Massage [id=" + id + ", title=" + title + ", content=" + content + ", createdTime=" + createdTime + "]";
	}


}
