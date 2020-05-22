<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
            <%@ page import="com.systop.entity.Book" %>
                        <%@ page import="com.systop.entity.Chapter" %>
            
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${path }/css/bookindex.css">
</head>
<body>
  <div class="bookinfo">
      <img src=" ${path }/${book.getImg() }" alt="">
      <div class="info">
          <span class="bookname">${book.getB_name()}</span>
          <span class="writername">作者：${book.getWritername()}</span>
            <span style="display: block">
                <span class="status"><c:choose>
                                   		<c:when test="${book.getStatus() ==0}">
                                   		<td>连载</td>
                                   		</c:when>
                                   		<c:otherwise>
                                   		<td>完结</td>
                                   		</c:otherwise>
                                   </c:choose> 
                </span>
                <span class="status"><c:choose>
                                   		<c:when test="${book.getPay() ==0}">
                                   		<td>免费</td>
                                   		</c:when>
                                   		<c:otherwise>
                                   		<td>付费</td>
                                   		</c:otherwise>
                                   </c:choose> 
                </span>
                <span class="status">${book.getTypename()}</span>
            </span>
            <p>${book.getJianjie()}</p>
            <div class="words">
                <span class="font">${book.getChapter()}</span><span class="danwei">章</span><div class="fenge"></div>
                <span  class="font">${book.getWords()}</span><span class="danwei">字</span><div class="fenge"></div>
                <span  class="font">${book.getVotes()}</span><span class="danwei">推荐票</span>
            </div>
            <div class="btn"><input type="button" value="免费试读"></div>
            <div class="btn"><input type="button" value="加入书架"></div>
            <div class="btn"><input type="button" value="投推荐票"></div>
        </div>
       
  </div>
  <div class="fenshu">9.5</div>
  <div class="jieshao">
        <p>作品信息</p>
      <div class="bookinfo">     
        &nbsp; &nbsp; &nbsp; &nbsp;<span class="bookinfo-jieshao">${book.getIntroduction() }</span>
      </div>
      <p>目录</p>
     <ul class="table">
     <c:forEach items="${chapter }" var="chap" varStatus="s">  
    <c:set var="chap" value="${chap }" scope="application"></c:set>
     <li><a href="" onclick="read();return false;"  ><span>第${chap.getChapterNum() }章&nbsp;${chap.getChapterName() }</span></a></li>
     </c:forEach>
     </ul>
  </div>
</body>
<script>
function read(chapnum,chapname){
	window.location.href="${path}/user/read.jsp?book=${book}&chap=${chap}";
}
</script>
</html>
