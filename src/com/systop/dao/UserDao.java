package com.systop.dao;
import java.util.List;

import com.systop.entity.Type;
import com.systop.entity.User;
public interface UserDao {
	public List<User> findUserAll();
	public int saveUser(User user);	
	public int updateUser(User user);	
	public int deleteUser(int id);	
	public int start(int id);
	public int stop(int id);
}
