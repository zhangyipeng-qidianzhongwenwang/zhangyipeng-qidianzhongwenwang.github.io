package com.systop.dao;

import java.util.List;

import com.systop.entity.Admin;

public interface AdminDao {
	/**
	 *   登录方法
	 * @param account
	 * @param adminpass
	 * @return
	 */
	public Admin loginAdmin(String account, String adminpass);
	
	/**
	 * 查询所有管理员列表
	 * @return 管理员集合
	 */
	public List<Admin> findAdminAll();
	
	/**
	 *   管理员保存
	 * @param admin
	 * @return
	 */
	public int saveAdmin(Admin admin);
	
	/**
	 *  根据id查询管理员
	 * @param id
	 * @return
	 */
	public Admin findAdminById(int id);
	
	/**
	 *  管理员更新
	 * @param admin
	 * @return
	 */
	public int updateAdmin(Admin admin);
	
	/**
	 *  根据Id删除管理员
	 * @param id
	 * @return
	 */
	public int deleteAdmin(int id);
	public int start(int id);
	public int stop(int id);
	public boolean enable(Admin admin);
}
