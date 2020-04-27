package com.systop.servlet;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.AdminDao;
import com.systop.daoimpl.AdminDaoImpl;
import com.systop.entity.Admin;

/**
 * Servlet implementation class doAdminLogin
 */
@WebServlet("/doAdminLogin")
public class doAdminLogin extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码
		request.setCharacterEncoding("UTF-8");
		//获取表达的数据
		String username = request.getParameter("username"); 
		String password = request.getParameter("password");
		
		//后台登录方法
		AdminDao admindao = new AdminDaoImpl();  
		Admin admin = admindao.loginAdmin(username, password);
		//判断结果 
		if (admin == null) {
			//作用域通讯request对象
			request.getSession().setAttribute("msg", "用户名或密码错误，请重新输入！");   		
			//response.sendRedirect("/admin/login.jsp");
			request.getRequestDispatcher("./admin/login.jsp").forward(request, response);
		} else {
			//登录成功
			InetAddress ip4 = Inet4Address.getLocalHost();
			admin.setIp(ip4);
			ServletContext application=getServletContext();
			application.setAttribute("adminname",admin.getAdmin());
			request.getSession().setAttribute("admin", admin);
			//response.sendRedirect("/hagen_dazs/index.jsp");
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
		}
	}

}
