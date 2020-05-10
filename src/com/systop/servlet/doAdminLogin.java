package com.systop.servlet;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.systop.dao.AdminDao;
import com.systop.daoimpl.AdminDaoImpl;
import com.systop.entity.Admin;
@WebServlet("/doAdminLogin")
public class doAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public doAdminLogin() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username"); 
		String password = request.getParameter("password");
		AdminDao admindao = new AdminDaoImpl();  
		Admin admin = admindao.loginAdmin(username, password);
		if (admin == null) {
			request.getSession().setAttribute("msg", "用户名或密码错误，请重新输入！");   		
			request.getRequestDispatcher("/admin/AdminLogin.jsp").forward(request, response);
		} else if(admindao.enable(admin)==false){
			request.getSession().setAttribute("msg", "该账号已被禁用，请换账号重新登录！");   	
			request.getRequestDispatcher("/admin/AdminLogin.jsp").forward(request, response);
		}else {
			InetAddress ip4 = Inet4Address.getLocalHost();
			admin.setIp(ip4);
			ServletContext application=getServletContext();
			application.setAttribute("adminname",admin.getAdmin());
			request.getSession().setAttribute("admin", admin);
			request.getRequestDispatcher("/admin/index.jsp").forward(request, response);

		}
	}

}
