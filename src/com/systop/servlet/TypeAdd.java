package com.systop.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.systop.dao.TypeDao;
import com.systop.daoimpl.TypeDaoImpl;
import com.systop.entity.Type;
@WebServlet("/TypeAdd")
public class TypeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TypeAdd() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typename = request.getParameter("type");
		Type type=new Type();
		type.setTypeName(typename);		
		TypeDao typedao=new TypeDaoImpl();
		int rows = typedao.saveType(type);
		if (rows > 0) {
			request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
		} else {
			
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}

}
