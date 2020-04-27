package com.systop.dao;

import java.util.List;

import com.systop.entity.Book;

public interface BookDao {
	
	public List<Book> findBookAll();
	
	
	public int saveBook(Book book);
	
	
	public Book findBookById(int id);
	

	public int updateBook(Book book);
	
	
	public int deleteBook(int id);
	public String findTypeById(int id);
	public String findWriterById(int id);
}
