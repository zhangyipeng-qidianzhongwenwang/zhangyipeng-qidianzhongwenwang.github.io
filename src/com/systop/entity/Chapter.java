package com.systop.entity;

import java.util.Date;

public class Chapter {
	private int ChapterId;
	private int ChapterNum;
	private String ChapterName;
	private int bookId;
	private String text;
	private int words;
	private Date date;
	public int getChapterId() {
		return ChapterId;
	}
	public void setChapterId(int chapterId) {
		ChapterId = chapterId;
	}
	public int getChapterNum() {
		return ChapterNum;
	}
	public void setChapterNum(int chapterNum) {
		ChapterNum = chapterNum;
	}
	public String getChapterName() {
		return ChapterName;
	}
	public void setChapterName(String chapterName) {
		ChapterName = chapterName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getWords() {
		return words;
	}
	public void setWords(int words) {
		this.words = words;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
