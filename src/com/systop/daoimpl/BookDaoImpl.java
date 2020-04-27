package com.systop.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.systop.dao.BaseDao;
import com.systop.dao.BookDao;
import com.systop.entity.Book;

public class BookDaoImpl extends BaseDao implements BookDao{

	@Override
	public List<Book> findBookAll() {
		List <Book>list = new ArrayList<Book>();
		Book book = null;
		String sql = "select * from book ";
		try {
			//获取连接数据库地址
			super.getConnection();			
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//执行sql语句
			rs = pstm.executeQuery();
			//处理结果
			while (rs.next()){
				book=new Book();
				book.setB_id(rs.getInt("b_id"));
				book.setB_name(rs.getString("b_name"));
				book.setChapter(rs.getInt("chapter"));
				book.setImg(rs.getString("img"));
				book.setPay(rs.getInt("pay"));
				book.setStatus(rs.getInt("status"));
				book.setTypeId(rs.getInt("typeId"));
				book.setVip(rs.getInt("vip"));
				book.setVotes(rs.getInt("votes"));
				book.setWords(rs.getInt("words"));
				book.setWriterId(rs.getInt("writerId"));	
				book.setTypename(this.findTypeById(rs.getInt("typeId")));
				book.setWritername(this.findWriterById(rs.getInt("writerId")));
				list.add(book);
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
	public int saveBook(Book book) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Book findBookById(int id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int updateBook(Book book) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int deleteBook(int id) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public String findTypeById(int id) {
		String name=null;
		ResultSet rs1=null;
		String sql = "select typeName from type where typeId = ?";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//替换参数
			pstm.setInt(1, id);
			//执行sql语句
			rs1 = pstm.executeQuery();
			//处理结果
			if (rs1.next()) {
				 name=rs1.getString("typeName");
				 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			//释放资源
			//super.closeAll();
		}
		return name;
	}

	@Override
	public String findWriterById(int id) {
		String name=null;
		ResultSet rs2=null;
		String sql = "select Pseudonyms from writer where writerId = ?";
		try {
			//获取连接数据库地址
			super.getConnection();
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//替换参数
			pstm.setInt(1, id);
			//执行sql语句
			 rs2 = pstm.executeQuery();
			//处理结果
			if (rs2.next()) {
				 name=rs2.getString("Pseudonyms");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			//释放资源
			///super.closeAll();
		}
		return name;
	}

}
