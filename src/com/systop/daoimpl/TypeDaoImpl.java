package com.systop.daoimpl;

import java.util.ArrayList;
import java.util.List;
import com.systop.dao.BaseDao;
import com.systop.dao.TypeDao;
import com.systop.entity.Type;
public class TypeDaoImpl extends BaseDao implements TypeDao{

	@Override
	public List<Type> findTypeAll() {
		List <Type>list = new ArrayList<Type>();
		Type type = null;
		String sql = "select * from type ";
		try {
			//获取连接数据库地址
			super.getConnection();			
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//执行sql语句
			rs = pstm.executeQuery();
			//处理结果
			while (rs.next()){
				type=new Type();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				list.add(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			super.closeAll();
		}
		return list;
	}

	@Override
	public int saveType(Type type) {
		int row = 0;
		String sql = "insert into type (typeName) values (?)";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//参数替换
			pstm.setString(1, type.getTypeName());			
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
	public int updateType(Type type) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int deleteType(int id) {
		int row = 0;
		String sql = "delete from type where typeId = ?";
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

}
