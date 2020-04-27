package com.systop.dao;

import java.util.List;

import com.systop.entity.Type;

public interface TypeDao {
public List<Type> findTypeAll();	
	public int saveType(Type type);	
	public int updateType(Type type);	
	public int deleteType(int id);	
}
