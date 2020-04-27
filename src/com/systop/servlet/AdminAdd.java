package com.systop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.AdminDao;
import com.systop.daoimpl.AdminDaoImpl;
import com.systop.entity.Admin;

/**
 * Servlet implementation class AdminAdd
 */
@WebServlet("/AdminAdd")
public class AdminAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//鑾峰彇椤甸潰鐨勫��
		String a_name = request.getParameter("account");
		String a_password = request.getParameter("adminPass");
		
		//瀹炰緥鍖朅dmin瀵硅薄鍙傛暟
		Admin admin = new Admin();
		admin.setAdmin(a_name);
		admin.setA_password(a_password);		
		//璋冪敤鍚庡彴鏂规硶
		AdminDao adminDao = new AdminDaoImpl();
		int rows = adminDao.saveAdmin(admin);
		//鏍规嵁褰卞搷琛屾暟璺宠浆椤甸潰
		if (rows > 0) {
			
			request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
		} else {
			
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}

}

