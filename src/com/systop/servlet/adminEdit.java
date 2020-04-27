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
 * Servlet implementation class adminEdit
 */
@WebServlet("/adminEdit")
public class adminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminEdit() {
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
		String a_name = request.getParameter("account");
		String a_password = request.getParameter("adminPass");
		String aid=request.getParameter("id");
		int id=Integer.parseInt(aid);
		Admin admin = new Admin();
		admin.setAdmin(a_name);
		admin.setA_password(a_password);	
		admin.setId(id);
		AdminDao adminDao = new AdminDaoImpl();
		int rows = adminDao.updateAdmin(admin);
		if (rows > 0) {			
			request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
		} else {			
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	}


