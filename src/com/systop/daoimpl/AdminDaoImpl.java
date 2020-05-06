package com.systop.daoimpl;

import java.util.ArrayList;
import java.util.List;
import com.systop.dao.AdminDao;
import com.systop.dao.BaseDao;
import com.systop.entity.Admin;

public class AdminDaoImpl extends BaseDao implements AdminDao {

	/**
	 *  登录方法
	 *  返回空表示登录失败
	 */
	@Override
	public Admin loginAdmin(String username, String password) {
		Admin admin = null;
		String sql = "select * from admin where admin = ? and a_password = ?";
		try {
			//获取连接数据库地址
			super.getConnection();
			
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//替换参数
			pstm.setString(1,username);
			pstm.setString(2, password);
			//执行sql语句
			rs = pstm.executeQuery();
			//处理结果
			if (rs.next()) {
				admin = new Admin();				
				admin.setId(rs.getInt("id"));
				admin.setAdmin(rs.getString("admin"));
				admin.setA_password(rs.getString("a_password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return admin;
	}

	/**
	 * 查询所有管理员列表
	 * @return 管理员集合
	 */
	@Override
	public List<Admin> findAdminAll() {
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select * from admin";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//执行sql语句
			rs = pstm.executeQuery();
			//处理结果
			while (rs.next()) {
				Admin admin = new Admin();				
				admin.setId(rs.getInt("id"));
				admin.setAdmin(rs.getString("admin"));
				admin.setA_password(rs.getString("a_password"));
				list.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return list;
	}

	/**
	 *   管理员保存
	 * @param admin
	 * @return
	 */
	@Override
	public int saveAdmin(Admin admin) {
		int row = 0;
		String sql = "insert into admin (admin, a_password) values (?,?)";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//参数替换
			pstm.setString(1, admin.getAdmin());
			pstm.setString(2, admin.getA_password());
			//执行sql语句
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return row;
	}

	/**
	 *  管理员更新
	 * @param admin
	 * @return
	 */
	@Override
	public int updateAdmin(Admin admin) {
		int row = 0;
		String sql = "update admin set admin = ?,a_password = ? where id = ?";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//参数替换
			pstm.setString(1, admin.getAdmin());
			pstm.setString(2, admin.getA_password());
			pstm.setInt(3, admin.getId());
			//执行sql语句
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return row;
	}

	/**
	 *  根据Id删除管理员
	 * @param id
	 * @return
	 */
	@Override
	public int deleteAdmin(int id) {
		int row = 0;
		String sql = "delete from admin where u_id = ?";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//参数替换
			pstm.setInt(1, id);
			//执行sql语句
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return row;
	}

	/**
	 *  根据id查询管理员
	 * @param id
	 * @return
	 */
	@Override
	public Admin findAdminById(int id) {
		Admin admin = null;
		String sql = "select * from admin where id = ?";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//替换参数
			pstm.setInt(1, id);
			//执行sql语句
			rs = pstm.executeQuery();
			//处理结果
			if (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAdmin(rs.getString("admin"));
				admin.setA_password(rs.getString("a_password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return admin;
	}

	@Override
	public int start(int id) {
		int row = 0;
		String sql = "update admin set status=1 where id=?";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//参数替换
			pstm.setInt(1, id);
			//执行sql语句
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return row;
	}

	@Override
	public int stop(int id) {
		int row = 0;
		String sql = "update admin set status=0 where id=?";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//参数替换
			pstm.setInt(1, id);
			//执行sql语句
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return row;
	}

	@Override
	public boolean enable(Admin admin) {
		boolean yorn=false;
		String sql = "select status from admin where admin = ? and a_password = ?";
		try {
			//获取连接数据库地址
			super.getConnection();			
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//替换参数
			pstm.setString(1,admin.getAdmin());
			pstm.setString(2,admin.getA_password());
			//执行sql语句
			rs = pstm.executeQuery();
			//处理结果
			if (rs.next()) {				
				if(rs.getInt("status") !=0) {
					yorn=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return yorn;
	}

}
