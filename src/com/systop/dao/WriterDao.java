package com.systop.dao;

import java.util.List;

import com.systop.entity.Type;
import com.systop.entity.Writer;

public interface WriterDao {
	public List<Writer> findWriterAll();	
	public int saveWriter(Writer writer);	
	public int updateWriter(Writer writer);	
	public int deleteWriter(int id);	
}
