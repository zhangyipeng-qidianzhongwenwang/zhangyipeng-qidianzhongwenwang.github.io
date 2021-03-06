package com.systop.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.systop.dao.TypeDao;
import com.systop.daoimpl.TypeDaoImpl;
@WebServlet("/typeDel")
public class typeDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public typeDel() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int aid = Integer.parseInt(id);
		TypeDao typedao=new TypeDaoImpl();
		int rows = typedao.deleteType(aid);
		if (rows > 0) {
			request.getRequestDispatcher("/admin/typeList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
