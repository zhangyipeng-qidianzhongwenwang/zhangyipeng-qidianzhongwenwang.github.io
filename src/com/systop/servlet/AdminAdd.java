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

@WebServlet("/AdminAdd")
public class AdminAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminAdd() {
        super();        
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a_name = request.getParameter("account");
		String a_password = request.getParameter("adminPass");
		Admin admin = new Admin();
		admin.setAdmin(a_name);
		admin.setA_password(a_password);		
		AdminDao adminDao = new AdminDaoImpl();
		int rows = adminDao.saveAdmin(admin);
		if (rows > 0) {
			
			request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
		} else {
			
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}

}

