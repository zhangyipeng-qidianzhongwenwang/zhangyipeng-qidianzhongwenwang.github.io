package com.systop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.systop.dao.AdminDao;
import com.systop.daoimpl.AdminDaoImpl;
@WebServlet("/AdminDel")
public class AdminDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminDel() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int aid = Integer.parseInt(id);
		AdminDao adminDao = new AdminDaoImpl();
		int rows = adminDao.deleteAdmin(aid);
		if (rows > 0) {
			request.getRequestDispatcher("/admin/adminList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
