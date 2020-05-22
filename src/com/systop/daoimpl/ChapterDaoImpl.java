package com.systop.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.systop.dao.BaseDao;
import com.systop.dao.ChapterDao;
import com.systop.entity.Chapter;
public class ChapterDaoImpl extends BaseDao implements ChapterDao{
	@Override
	public List<Chapter> findById(int id){
		List <Chapter>list = new ArrayList<Chapter>();
		Chapter chapter = null;
		String sql = "select * from chapter where bookId=? ORDER BY ChapterNum ASC";
		try {
			//获取连接数据库地址
			super.getConnection();			
			//创建pstmt
			pstm = con.prepareStatement(sql);
			//执行sql语句
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			//处理结果
			while (rs.next()){
				chapter=new Chapter();
				chapter.setChapterNum(rs.getInt("ChapterNum"));
				chapter.setChapterName(rs.getString("ChapterName"));
				chapter.setText(rs.getString("text"));
				list.add(chapter);
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
