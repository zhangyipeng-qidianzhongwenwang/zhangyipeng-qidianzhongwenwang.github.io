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
			//��ȡ�������ݿ��ַ
			super.getConnection();			
			//����pstmt
			pstm = con.prepareStatement(sql);
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
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
			//�ͷ���Դ
			super.closeAll();
		}
		return list;
	}

	@Override
	public int saveWriter(Writer writer) {
		int row = 0;
		String sql = "insert into writer (Pseudonyms,name) values (?,?)";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�����滻
			pstm.setString(1, writer.getPseudonyms());		
			pstm.setString(2, writer.getName());
			//ִ��sql���
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//�ͷ���Դ
			super.closeAll();
		}
		return row;
	}

	@Override
	public int updateWriter(Writer writer) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int deleteWriter(int id) {
		int row = 0;
		String sql = "delete from writer where writerId = ?";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�����滻
			pstm.setInt(1, id);
			//ִ��sql���
			row = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//�ͷ���Դ
			super.closeAll();
		}
		return row;
	}

}
