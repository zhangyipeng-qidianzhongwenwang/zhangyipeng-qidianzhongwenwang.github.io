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
			//��ȡ�������ݿ��ַ
			super.getConnection();			
			//����pstmt
			pstm = con.prepareStatement(sql);
			//ִ��sql���
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			//������
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
			//�ͷ���Դ
			super.closeAll();
		}
		return list;
	}

}
