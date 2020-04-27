package com.systop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.WriterDao;
import com.systop.daoimpl.WriterDaoImpl;
import com.systop.entity.Writer;

/**
 * Servlet implementation class writerAdd
 */
@WebServlet("/writerAdd")
public class writerAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public writerAdd() {
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
		request.setCharacterEncoding("UTF-8");
		String Pseudonyms = request.getParameter("Pseudonyms");
		String name = request.getParameter("name");
		Writer writer = new Writer();
		writer.setPseudonyms(Pseudonyms);
		writer.setName(name);
		WriterDao writerdao=new WriterDaoImpl();
		int rows = writerdao.saveWriter(writer);
		if (rows > 0) {
			
			request.getRequestDispatcher("/admin/success.jsp").forward(request, response);
		} else {
			
			request.getRequestDispatcher("/admin/error.jsp").forward(request, response);
		}
	}

}
