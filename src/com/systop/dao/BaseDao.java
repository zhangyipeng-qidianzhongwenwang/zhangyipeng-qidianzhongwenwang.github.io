package com.systop.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.util.List;

import com.systop.entity.Chapter;

	public class BaseDao {
		//�������ݿ����
		private static final String DRIVER = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3306/���������";
		private static final String UNAME = "root";
		private static final String UPWD = "root";

		//���ݿ����
		protected Connection con;// ���ݿ����Ӷ���
		protected PreparedStatement pstm;// Ԥ�����SQL������
		protected Statement stmt;// SQL������
		protected ResultSet rs;// ���������

		/**
		 * ��ȡ���ݿ����ӷ���
		 * @throws Exception
		 */
		protected void getConnection() throws Exception {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, UNAME, UPWD);
		}

		/**
		 * �ͷ����ݿ���Դ
		 */
		protected void closeAll() {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				if (con != null && con.isClosed() == false) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/**
		 * ִ��SQL���,����ִ������ɾ���ĵĲ���������ִ�в�ѯ
		 * @param sql    Ԥ�����sql���
		 * @param param  sql����������
		 * @return rows  ������Ӱ�������
		 */
		protected int executeSQL(String sql, String[] param) throws Exception {
			int rows = 0; // ��Ӱ�������

			try {
				this.getConnection();
				if (param != null && param.length > 0) {
					pstm = con.prepareStatement(sql);
					// ѭ������SQL�����������е�ֵ���θ���Ԥִ�����
					for (int i = 0; i < param.length; i++) {
						// ע�⣬setXXX()����������ֵ��1��ʼ��������i+1
						pstm.setString(i + 1, param[i]);
					}
					rows = pstm.executeUpdate();
				} else {
					// ����Statement����ִ�и���sql��䣬������Ӱ�������
					stmt = con.createStatement();
					rows = stmt.executeUpdate(sql);
				}
			} finally {
				this.closeAll();// �ͷ���Դ
			}
			System.out.println("����ͨ�õ�����ɾ���ķ����ɹ���");
			return rows;// ������Ӱ�������
		}

		public List<Chapter> findById(int id) {
			// TODO �Զ����ɵķ������
			return null;
		}
	}


