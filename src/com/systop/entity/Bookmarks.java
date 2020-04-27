package com.systop.entity;

import java.util.Date;

public class Bookmarks {
	private int id;
	private int user_id;
	private int chapter_id;
	private Date  date;
	private int book_kd;
	public int getBook_kd() {
		return book_kd;
	}
	public void setBook_kd(int book_kd) {
		this.book_kd = book_kd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
