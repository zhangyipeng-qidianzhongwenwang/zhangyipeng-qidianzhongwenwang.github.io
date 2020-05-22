package com.systop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.systop.dao.AdminDao;
import com.systop.dao.BookDao;
import com.systop.dao.ChapterDao;
import com.systop.daoimpl.AdminDaoImpl;
import com.systop.daoimpl.BookDaoImpl;
import com.systop.daoimpl.ChapterDaoImpl;
import com.systop.entity.Book;
import com.systop.entity.Chapter;

/**
 * Servlet implementation class bookindex
 */
@WebServlet("/bookindex")
public class bookindex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookindex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int aid = Integer.parseInt(id);
		BookDao bookDao = new BookDaoImpl();
		Book book = bookDao.findBookById(aid);
		ChapterDao chapterdao=new ChapterDaoImpl();
		List<Chapter> chapter=chapterdao.findById(aid);
		ServletContext application=getServletContext();
		application.setAttribute("book", book);
		application.setAttribute("chapter", chapter);
		request.getRequestDispatcher("/user/bookindex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
