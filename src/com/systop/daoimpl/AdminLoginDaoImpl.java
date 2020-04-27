package com.systop.daoimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.systop.entity.AdminLogin;
import com.systop.dao.AdminLoginDao;
import com.systop.dao.BaseDao;
import com.systop.entity.Admin;

public class AdminLoginDaoImpl extends BaseDao implements AdminLoginDao{

	@Override
	public int adminLoginAdd(String name, String ip, Date date) {
		int row=0;
		String sql="insert into adminlogin(adminname,ip,time) values(?,?,?)";
		try {
			super.getConnection();
			pstm=con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, ip);
//			java.sql.Date d=new java.sql.Date(date.getTime());
			 SimpleDateFormat ft = 
				      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
			pstm.setString(3, ft.format(date));
			row=pstm.executeUpdate();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<AdminLogin> adminLoginFinAll() {
		// TODO 自动生成的方法存根
		List<AdminLogin> list = new ArrayList<AdminLogin>();
		String sql = "select * from adminlogin";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//执行sql语句
			rs = pstm.executeQuery();
			//处理结果
			while (rs.next()) {
				AdminLogin adminlogin = new AdminLogin();				
				adminlogin.setId(rs.getInt("adminid"));
				adminlogin.setIp(rs.getString("ip"));
				adminlogin.setTime(rs.getString("time"));
				adminlogin.setName(rs.getString("adminname"));
				list.add(adminlogin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return list;

	}

}
