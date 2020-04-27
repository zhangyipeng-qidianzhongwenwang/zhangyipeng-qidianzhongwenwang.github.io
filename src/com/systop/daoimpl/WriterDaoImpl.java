package com.systop.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.systop.dao.BaseDao;
import com.systop.dao.WriterDao;
import com.systop.entity.Type;
import com.systop.entity.User;
import com.systop.entity.Writer;

public class WriterDaoImpl extends BaseDao implements WriterDao{

	@Override
	public List<Writer> findWriterAll() {
		List <Writer>list = new ArrayList<Writer>();
		Writer writer = null;
		String sql = "select * from writer ";
		try {
			//获取连接数据库地址
			super.getConnection();			
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//执行sql语句
			rs = pstm.executeQuery();
			//处理结果
			while (rs.next()){
				writer=new Writer();
				writer.setName(rs.getString("name"));
				writer.setPseudonyms(rs.getString("Pseudonyms"));
				writer.setWriterId(rs.getInt("writerId"));
				list.add(writer);
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
	public int saveWriter(Writer writer) {
		int row = 0;
		String sql = "insert into writer (Pseudonyms,name) values (?,?)";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//参数替换
			pstm.setString(1, writer.getPseudonyms());		
			pstm.setString(2, writer.getName());
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
	public int updateWriter(Writer writer) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int deleteWriter(int id) {
		int row = 0;
		String sql = "delete from writer where writerId = ?";
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
