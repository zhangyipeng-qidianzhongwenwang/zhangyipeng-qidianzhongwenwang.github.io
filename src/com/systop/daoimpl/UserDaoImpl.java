package com.systop.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.systop.dao.BaseDao;
import com.systop.dao.UserDao;
import com.systop.entity.Type;
import com.systop.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public int saveUser(User user) {
		int row = 0;
		String sql = "insert into user (u_name,u_password,sex,mail,address,phone) values (?,?,?,?,?,?)";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();
			//����pstmt
			pstm = con.prepareStatement(sql);
			//�����滻
			pstm.setString(1, user.getU_name());
			pstm.setString(2, user.getU_password());
			pstm.setInt(3, user.getSex());
			pstm.setString(4, user.getMail());
			pstm.setString(5, user.getAddress());
			pstm.setString(6,user.getPhone());
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
	public int updateUser(User user) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		int row = 0;
		String sql = "delete from user where u_id = ?";
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
	public List<User> findUserAll() {
		List <User>list = new ArrayList<User>();
		User user = null;
		String sql = "select * from user ";
		try {
			//��ȡ�������ݿ��ַ
			super.getConnection();			
			//����pstmt
			pstm = con.prepareStatement(sql);
			//ִ��sql���
			rs = pstm.executeQuery();
			//������
			while (rs.next()){
				user = new User();
				user.setAddress(rs.getString("address"));
				user.setBalance(rs.getInt("balance"));
				user.setLevel(rs.getInt("level"));
				user.setMail(rs.getString("mail"));
				user.setPhone(rs.getString("phone"));
				user.setSex(rs.getInt("sex"));
				user.setStatus(rs.getInt("status"));
				user.setU_id(rs.getInt("u_id"));
				user.setU_name(rs.getString("u_name"));
				user.setU_password(rs.getString("u_password"));
				user.setVip(rs.getInt("vip"));
				list.add(user);
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
	public int start(int id) {
		int row = 0;
		String sql = "update user set status=1 where id=?";
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

}
