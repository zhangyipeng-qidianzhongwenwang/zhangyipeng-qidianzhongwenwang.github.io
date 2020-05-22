<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="java.util.List" %>
   <%@ page import="com.systop.dao.BookDao" %>
   <%@ page import="com.systop.daoimpl.BookDaoImpl" %>
   <%@ page import="com.systop.entity.Book" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%    
    	//实例化操作对象
	BookDao bookDao = new BookDaoImpl();
	List<Book> list = bookDao.findBookAll();
	request.setAttribute("list", list);
	%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>起点中文网</title>
    <link rel="stylesheet" href="${path }/css/userindex.css">
</head>
<body>
	        <div class="book-list">
           <c:forEach items="${list }" var="admin" varStatus="s">   
            <div class="book">
                <a href="${path }/user/bookindex.jsp" onclick="setid(${admin.getB_id()}); return false;" href="javascript:;"><img src=" ${path }/${admin.getImg() }" alt=""></a>
              <div class="message">
                <span class="bookname">${admin.getB_name() }</span>
                <span class="writename" >${admin.getWritername() }</span>
                <span class="info">${admin.getTypename() }</span>
                <span class="info">
                	<c:choose>
                                   		<c:when test="${admin.getStatus() ==0}">
                                   		<td>连载</td>
                                   		</c:when>
                                   		<c:otherwise>
                                   		<td>完结</td>
                                   		</c:otherwise>
                                   </c:choose> 
                </span>
                <span class="info">${admin.getWords() }</span>
                <span class="jianjie">
                  ${admin.getJianjie()  }
                </span>
              </div>
            </div>
              </c:forEach>
         </div>
</body>

 <script>
 function setid(id){     
         window.location.href="/起点中文网/bookindex?id="+id;

         }
</script>
</html>