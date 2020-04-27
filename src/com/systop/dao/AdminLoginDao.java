package com.systop.dao;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import com.systop.entity.AdminLogin;
public interface AdminLoginDao {
	public int adminLoginAdd(String name,String string,Date date);
	public List<AdminLogin> adminLoginFinAll();
}
