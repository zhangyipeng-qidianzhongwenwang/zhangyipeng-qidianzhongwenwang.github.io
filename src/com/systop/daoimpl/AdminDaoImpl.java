package com.systop.daoimpl;

import java.util.ArrayList;
import java.util.List;
import com.systop.dao.AdminDao;
import com.systop.dao.BaseDao;
import com.systop.entity.Admin;

public class AdminDaoImpl extends BaseDao implements AdminDao {

	/**
	 *  ��¼����
	 *  ���ؿձ�ʾ��¼ʧ��
	 */
	@Override
	public Admin loginAdmin(String username, String password) {
		Admin admin = null;
		String sql = "select * from admin where admin = ? and a_password = ?";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();
			
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�滻����
			pstm.setString(1,username);
			pstm.setString(2, password);
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
			if (rs.next()) {
				admin = new Admin();				
				admin.setId(rs.getInt("id"));
				admin.setAdmin(rs.getString("admin"));
				admin.setA_password(rs.getString("a_password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//�ͷ���Դ
			super.closeAll();
		}
		return admin;
	}

	/**
	 * ��ѯ���й���Ա�б�
	 * @return ����Ա����
	 */
	@Override
	public List<Admin> findAdminAll() {
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select * from admin";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
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
			//�ͷ���Դ
			super.closeAll();
		}
		return list;
	}

	/**
	 *   ����Ա����
	 * @param admin
	 * @return
	 */
	@Override
	public int saveAdmin(Admin admin) {
		int row = 0;
		String sql = "insert into admin (admin, a_password) values (?,?)";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�����滻
			pstm.setString(1, admin.getAdmin());
			pstm.setString(2, admin.getA_password());
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

	/**
	 *  ����Ա����
	 * @param admin
	 * @return
	 */
	@Override
	public int updateAdmin(Admin admin) {
		int row = 0;
		String sql = "update admin set admin = ?,a_password = ? where id = ?";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�����滻
			pstm.setString(1, admin.getAdmin());
			pstm.setString(2, admin.getA_password());
			pstm.setInt(3, admin.getId());
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

	/**
	 *  ����Idɾ������Ա
	 * @param id
	 * @return
	 */
	@Override
	public int deleteAdmin(int id) {
		int row = 0;
		String sql = "delete from admin where u_id = ?";
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

	/**
	 *  ����id��ѯ����Ա
	 * @param id
	 * @return
	 */
	@Override
	public Admin findAdminById(int id) {
		Admin admin = null;
		String sql = "select * from admin where id = ?";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�滻����
			pstm.setInt(1, id);
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
			if (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAdmin(rs.getString("admin"));
				admin.setA_password(rs.getString("a_password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//�ͷ���Դ
			super.closeAll();
		}
		return admin;
	}

	@Override
	public int start(int id) {
		int row = 0;
		String sql = "update admin set status=1 where id=?";
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

	@Override
	public int stop(int id) {
		int row = 0;
		String sql = "update admin set status=0 where id=?";
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

	@Override
	public boolean enable(Admin admin) {
		boolean yorn=false;
		String sql = "select status from admin where admin = ? and a_password = ?";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();			
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�滻����
			pstm.setString(1,admin.getAdmin());
			pstm.setString(2,admin.getA_password());
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
			if (rs.next()) {				
				if(rs.getInt("status") !=0) {
					yorn=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//�ͷ���Դ
			super.closeAll();
		}
		return yorn;
	}

}
