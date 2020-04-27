package com.systop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.AdminDao;
import com.systop.dao.UserDao;
import com.systop.daoimpl.AdminDaoImpl;
import com.systop.daoimpl.UserDaoImpl;
import com.systop.entity.Admin;
import com.systop.entity.User;

/**
 * Servlet implementation class UserAdd
 */
@WebServlet("/UserAdd")
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAdd() {
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
		String name = request.getParameter("name");
		String password = request.getParameter("password");	
		String sex=request.getParameter("sex");
		int usex=Integer.parseInt(sex);
		String mail=request.getParameter("mail");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		User user=new User();
		user.setAddress(address);	
		user.setMail(mail);
		user.setPhone(phone);
		user.setU_name(name);
		user.setU_password(password);
		user.setSex(usex);
		UserDao userdao=new UserDaoImpl();
		int rows = userdao.saveUser(user);
		if (rows > 0) {
			
			request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
		} else {
			
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}

}
