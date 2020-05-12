<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%
     application.setAttribute("path", request.getContextPath());%>       
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>起点中文网</title>
    <link rel="stylesheet" href="../css/userindex.css">
    
</head>
<body>
    <div class="page">
        <div class="title">
            <div class="title_left">
                <ul>
                    <li>
                        <a href="">起点中文网</a>
                        <div class="fenge"></div>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="">起点女生网</a>
                        <div class="fenge"></div>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="">创世中文网</a>
                        <div class="fenge"></div>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="">云起书院</a>
                        <div class="fenge"></div>
                    </li>
                </ul>
                <ul>
                    <li>
                        <a href="">繁体版</a>
                    </li>
                </ul>
            </div>
            <div class="title_right">
                    <ul>
                            <li>
                                <a href="">注册</a>                        
                            </li>
                        </ul>    
                <ul>
                    <li>
                        <a href="" class="login">登录</a>
                        <div class="fenge"></div>
                    </li>
                </ul>                          
            </div>
        </div>
        <img src="../images/game.png" alt="" class="game">
        <div class="top">
                <a href=""><img src="../images/logo.png" alt="" class="logo"></a>
                <div class="search">
                    <input type="text" placeholder="在此输入书名">
                    <div class="sousuo">
                    <a href=""><img src="../images/search.png" alt=""></a> 
                    </div>
                </div>
                <a class="shujia" href="">
                    <img src="../images/book.png" alt="" class="bookicon">
                    我的书架
                </a>
            </div>
        <div class="daohang">
            <ul>
                <li><a href="">玄幻小说</a></li>
                <li><a href="">言情小说</a></li>
                <li><a href="">军事小说</a></li>
                <li><a href="">历史小说</a></li>
                <li><a href="">武侠小说</a></li>
                <li><a href="">灵异小说</a></li>
                <li><a href="">免费小说</a></li>
                <li><a href="">完本小说</a></li>
            
                <li><a href="">票数排行</a></li>
            </ul>
        </div>         
            <div class="iframe">
                        <iframe src='http://localhost:8888/起点中文网/user/indexlist.jsp' width="100%"  scrolling="no" frameborder="0"  class="x-iframe" id="mainIframe"></iframe>
                    </div>
                    <div class="footer">
                    <span>Copyright (C) 2020 chuangshi.qq.com All Rights Reserved 上海阅文信息技术有限公司 版权所有 本网站由腾讯云提供服务器和带宽支持</span>
                    <span>请所有作者发布作品时务必遵守国家互联网信息管理办法规定，我们拒绝任何色情小说，一经发现，即作删除！举报电话：010-59357051</span>
                    <span>联系方式 总机 021-61870500 地址：中国（上海）自由贸易试验区碧波路690号6号楼101、201室
                    </span>
                    </div>
    </div>    
</body>
<script language="javascript">
	var timeIframe;
	window.onload = function() {
		timeIframe = setTimeout(GetIframeStatus, 10);
	}
	function GetIframeStatus() {
		var iframe = document.getElementById("mainIframe");
		var iframeWindow = iframe.contentWindow;
		//内容是否加载完
		if (iframeWindow.document.readyState == "complete") {
			var iframeWidth, iframeHeight;
			//获取Iframe的内容实际宽度
			iframeWidth = iframeWindow.document.documentElement.scrollWidth;
			//获取Iframe的内容实际高度
			iframeHeight = iframeWindow.document.documentElement.scrollHeight;
			//设置Iframe的宽度
			iframe.width = iframeWidth;
			//设置Iframe的高度
			iframe.height = iframeHeight;
		} else {
			timeIframe = setTimeout(GetIframeStatus, 10);
		}
	}

</script>
 
</html>