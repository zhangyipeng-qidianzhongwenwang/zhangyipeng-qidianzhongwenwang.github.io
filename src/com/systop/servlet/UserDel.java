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

@WebServlet("/UserDel")
public class UserDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserDel() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int aid = Integer.parseInt(id);
		UserDao UserDao = new UserDaoImpl();
		int rows = UserDao.deleteUser(aid);
		if (rows > 0) {
			request.getRequestDispatcher("/user/UserList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
