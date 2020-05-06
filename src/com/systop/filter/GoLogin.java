package com.systop.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter("/admin/*")//���÷�Χ��admin���µ������ļ�
public class GoLogin implements Filter {
    public GoLogin() {
    	
    }
	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsr=(HttpServletRequest)request;
		String uri=hsr.getRequestURI();

		if(uri.contains("/AdminLogin.jsp")) {//����login�ļ�������������
			chain.doFilter(request, response);
		}else {
			ServletContext req=hsr.getServletContext();
			Object adminname=req.getAttribute("adminname");
			if(adminname==null ){
				hsr.getSession().setAttribute("msg", "���¼�����");
				request.getRequestDispatcher("/admin/AdminLogin.jsp").forward(request, response);
			}else {				
				chain.doFilter(request, response);
			}			
		}		

	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
