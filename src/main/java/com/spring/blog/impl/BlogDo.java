package com.spring.blog.impl;

public class BlogDo {

	private int seq;
	private String title;
	private String content;
	private String color;
	
	@Override
	public String toString() {
		return "BoardDo [seq=" + seq + 
				", title=" + title + 
				", content=" + content + 
				", color=" + color + "]";
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	

}
