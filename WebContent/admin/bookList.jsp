<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ page import="java.util.List" %>
   <%@ page import="com.systop.dao.BookDao" %>
   <%@ page import="com.systop.daoimpl.BookDaoImpl" %>
   <%@ page import="com.systop.entity.Book" %>
    <%
	//实例化操作对象
	BookDao bookDao = new BookDaoImpl();
    request.setAttribute("bookdao", bookDao);
	List<Book> list = bookDao.findBookAll();
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>起点中文书籍管理页</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${path }/css/font.css">
        <link rel="stylesheet" href="${path }/css/xadmin.css">
        <script src="${path }/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${path }/js/xadmin.js"></script>
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
  
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5" id="form1" name="form1">
                              <input type="hidden" id="hidden1" name="jsParam"/>
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="开始日" name="start" id="start">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="截止日" name="end" id="end">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                                </div>
                            </form>
                        </div>
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加用户','./adminAdd.jsp',600,400)"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body ">
                            <table class="layui-table layui-form" width="100%">
                              <thead>
                                <tr>
                                  <th>
                                    <input type="checkbox" name=""  lay-skin="primary">
                                  </th>
                                  <th width="5%">ID</th>
                                  <th>书名</th>
                                  <th>类型</th>
                                  <th>作者名</th>
                                  <th width="5%">字数</th>
                                  <th>章节数</th>
                                  <th>是否付费</th>
                                  <th>是否为VIP用户阅读</th>
                                  <th>状态</th>
                                 <th>得票数</th>
                                   <%-- <th>操作</th>    --%>                             
                              </thead>
                              <tbody>
                               <c:forEach items="${list }" var="book" varStatus="s">                           
                                <tr>
                                  <td>
                                    <input type="checkbox" name=""  lay-skin="primary">
                                  </td>
                                  <td>${book.getB_id() }</td>
                                  <td>${book.getB_name() }</td>     
                                  <td>${book.getTypename() }</td>                             
                                 <td>${book.getWritername() }</td>  
                                 <td>${book.getWords() }</td> 
                                 <td>${book.getChapter() }</td>  
                                 <c:choose>
                                   		<c:when test="${book.getPay() ==0 }">
                                   		<td>否</td>
                                   		</c:when>
                                   		<c:otherwise>
                                   		<td>是</td>
                                   		</c:otherwise>
                                   </c:choose>
                                   <c:choose>
                                   		<c:when test="${book.getVip() ==0 }">
                                   		<td>否</td>
                                   		</c:when>
                                   		<c:otherwise>
                                   		<td>是</td>
                                   		</c:otherwise>
                                   </c:choose>
                                   <c:choose>
                                   		<c:when test="${book.getStatus() ==0 }">
                                   		<td>连载中</td>
                                   		</c:when>
                                   		<c:otherwise>
                                   		<td>已完结</td>
                                   		</c:otherwise>
                                   </c:choose>
                                  <td>${book.getVotes() }</td>
                                 <%--     <td class="td-manage">
                                     <a onclick="member_stop(this,'${book.getId() }')" href="javascript:;"  title="禁用">
                                        <i class="layui-icon">&#xe62f;</i>
                                      </a>
                                      <a onclick="member_start(this,'${book.getId() }')" href="javascript:;"  title="启用">
                                        <i class="layui-icon">&#xe601;</i>
                                      </a>
                                    </a>
                                    <a title="编辑"  onclick="xadmin.open('编辑','./adminEdit.jsp?id='+${book.getId() },600,400)" >
                                      <i class="layui-icon">&#xe642;</i>
                                    </a>
                                    <a title="删除" onclick="member_del(this,${book.getId() })" href="javascript:;">
                                      <i class="layui-icon">&#xe640;</i>
                                    </a>
                                  </td>--%> 
                                </tr>
                             </c:forEach>
                              </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                  <a class="prev" href="">&lt;&lt;</a>
                                  <a class="num" href="">1</a>
                                  <span class="current">2</span>
                                  <a class="num" href="">3</a>
                                  <a class="num" href="">489</a>
                                  <a class="next" href="">&gt;&gt;</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script>
      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var form = layui.form;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
</html>