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
			request.getSession().setAttribute("msg", "�û���������������������룡");   		
			request.getRequestDispatcher("/admin/AdminLogin.jsp").forward(request, response);
		} else if(admindao.enable(admin)==false){
			request.getSession().setAttribute("msg", "���˺��ѱ����ã��뻻�˺����µ�¼��");   	
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
