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
			//��ȡ�������ݿ��ַ
			super.getConnection();			
			//����pstmt
			pstm = con.prepareStatement(sql);
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
			while (rs.next()){
				type=new Type();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				list.add(type);
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
	public int saveType(Type type) {
		int row = 0;
		String sql = "insert into type (typeName) values (?)";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�����滻
			pstm.setString(1, type.getTypeName());			
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
	public int updateType(Type type) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int deleteType(int id) {
		int row = 0;
		String sql = "delete from type where typeId = ?";
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
