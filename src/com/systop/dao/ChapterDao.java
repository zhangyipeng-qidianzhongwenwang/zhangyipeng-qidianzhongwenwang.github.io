package com.systop.dao;

import java.util.List;

import com.systop.entity.Chapter;

public interface ChapterDao {
	public List<Chapter> findById(int id);
}
